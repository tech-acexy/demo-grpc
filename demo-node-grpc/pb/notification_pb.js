const protobuf = require('protobufjs');

// 定义 protobuf schema
const protoSchema = `
syntax = "proto3";

package notification;

// 统一的消息内容定义
message MessageContent {
  string type = 1;        // 类型: "match" 或 "odds"
  int64 matchId = 2;      // 比赛ID
  oneof data {
    MatchData match_data = 3;     // 比赛数据 (当type="match"时使用)
    OddsDataList odds_data = 4;   // 赔率数据数组 (当type="odds"时使用)
  }
}

// 比赛数据定义
message MatchData {
  int64 id = 1;                    // 比赛ID
  int64 startTime = 2;             // 开始时间 (驼峰命名)
  optional int64 endTime = 3;      // 结束时间 (可选，可能为null)
  int32 matchStatus = 4;           // 比赛状态 (驼峰命名)
  string statusDesc = 5;           // 状态描述 (驼峰命名)
  string result = 6;               // 比赛结果(JSON字符串)
  string periods = 7;              // 阶段数据(JSON字符串)
  optional int64 periodTime = 8;   // 阶段时间 (可选，驼峰命名)
  int64 homeTeamId = 9;            // 主队ID (驼峰命名)
  int32 homeScore = 10;            // 主队得分 (驼峰命名)
  int64 awayTeamId = 11;           // 客队ID (驼峰命名)
  int32 awayScore = 12;            // 客队得分 (驼峰命名)
  int64 updateTime = 13;           // 更新时间 (驼峰命名)
}

// 赔率数据列表定义
message OddsDataList {
  repeated OddsData data = 1;      // 赔率数据数组
}

// 赔率数据定义
message OddsData {
  string code = 1;                 // 赔率代码
  double value = 2;                // 赔率值
  int32 status = 3;                // 状态
  int64 updateTime = 4;            // 更新时间 (驼峰命名)
}
`;

// 编译 protobuf schema
const root = protobuf.parse(protoSchema).root;

// 获取消息类型
const MessageContent = root.lookupType('notification.MessageContent');
const MatchData = root.lookupType('notification.MatchData');
const OddsData = root.lookupType('notification.OddsData');
const OddsDataList = root.lookupType('notification.OddsDataList');

/**
 * 通知消息工厂类
 */
class NotificationMessageFactory {

    /**
     * 创建比赛数据消息
     * @param {Object} matchData - 比赛数据对象
     * @returns {Object} 编码后的消息对象
     */
    static createMatchMessage(matchData) {
        // 验证比赛数据
        const matchDataPayload = MatchData.create(matchData);
        const errMsg = MatchData.verify(matchDataPayload);
        if (errMsg) throw Error(errMsg);

        // 创建消息内容
        const messageContent = {
            type: 'match',
            matchId: matchData.id,
            match_data: matchDataPayload
        };

        return MessageContent.create(messageContent);
    }

    /**
     * 创建赔率数据消息
     * @param {number} matchId - 比赛ID
     * @param {Array} oddsDataArray - 赔率数据数组
     * @returns {Object} 编码后的消息对象
     */
    static createOddsMessage(matchId, oddsDataArray) {
        // 验证赔率数据
        const oddsDataList = OddsDataList.create({ data: oddsDataArray });
        const errMsg = OddsDataList.verify(oddsDataList);
        if (errMsg) throw Error(errMsg);

        // 创建消息内容
        const messageContent = {
            type: 'odds',
            matchId: matchId,
            odds_data: oddsDataList
        };

        return MessageContent.create(messageContent);
    }

    /**
     * 序列化消息为二进制数据
     * @param {Object} message - 消息对象
     * @returns {Uint8Array} 二进制数据
     */
    static encode(message) {
        return MessageContent.encode(message).finish();
    }

    /**
     * 从二进制数据反序列化消息
     * @param {Uint8Array} buffer - 二进制数据
     * @returns {Object} 消息对象
     */
    static decode(buffer) {
        return MessageContent.decode(buffer);
    }

    /**
     * 序列化消息为JSON字符串
     * @param {Object} message - 消息对象
     * @returns {string} JSON字符串
     */
    static toJSON(message) {
        return JSON.stringify(MessageContent.toObject(message, {
            longs: String,
            enums: String,
            bytes: String,
        }));
    }

    /**
     * 从JSON字符串创建消息
     * @param {string} json - JSON字符串
     * @returns {Object} 消息对象
     */
    static fromJSON(json) {
        const obj = JSON.parse(json);
        return MessageContent.fromObject(obj);
    }
}

/**
 * 比赛数据辅助类
 */
class MatchDataHelper {

    /**
     * 创建比赛数据对象
     * @param {Object} params - 比赛参数
     * @returns {Object} 比赛数据对象
     */
    static create(params) {
        const {
            id,
            startTime,
            endTime = null,
            matchStatus,
            statusDesc,
            result = '{}',
            periods = '{}',
            periodTime = null,
            homeTeamId,
            homeScore = 0,
            awayTeamId,
            awayScore = 0,
            updateTime = Date.now()
        } = params;

        const matchData = {
            id,
            startTime,
            matchStatus,
            statusDesc,
            result,
            periods,
            homeTeamId,
            homeScore,
            awayTeamId,
            awayScore,
            updateTime
        };

        // 添加可选字段
        if (endTime !== null) {
            matchData.endTime = endTime;
        }
        if (periodTime !== null) {
            matchData.periodTime = periodTime;
        }

        return matchData;
    }
}

module.exports = {
    MessageContent,
    MatchData,
    OddsData,
    OddsDataList,
    NotificationMessageFactory,
    MatchDataHelper
};

/**
 * 赔率数据辅助类
 */
class OddsDataHelper {

    /**
     * 创建赔率数据对象
     * @param {Object} params - 赔率参数
     * @returns {Object} 赔率数据对象
     */
    static create(params) {
        const {
            code,
            value,
            status,
            updateTime = Date.now()
        } = params;

        return {
            code,
            value,
            status,
            updateTime
        };
    }

    /**
     * 创建赔率数据数组
     * @param {Array} oddsArray - 赔率参数数组
     * @returns {Array} 赔率数据数组
     */
    static createArray(oddsArray) {
        return oddsArray.map(odds => this.create(odds));
    }
}

// 导出类和常量
module.exports = {
    // protobuf 消息类型
    MessageContent,
    MatchData,
    OddsData,
    OddsDataList,

    // 工厂类和辅助类
    NotificationMessageFactory,
    MatchDataHelper,
    OddsDataHelper,

    // protobuf root (用于高级用法)
    root
};