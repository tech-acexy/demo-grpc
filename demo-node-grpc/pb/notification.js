/*eslint-disable*/
"use strict";
var $protobuf = require("protobufjs/minimal");

var $root = $protobuf.roots["default"] || ($protobuf.roots["default"] = {});

$root.notification = (function() {

    var notification = {};

    notification.MessageContent = (function() {

        function MessageContent(p) {
            if (p)
                for (var ks = Object.keys(p), i = 0; i < ks.length; ++i)
                    if (p[ks[i]] != null)
                        this[ks[i]] = p[ks[i]];
        }

        MessageContent.prototype.type = "";
        MessageContent.prototype.matchId = $protobuf.Long ? $protobuf.Long.fromBits(0,0,false) : 0;
        MessageContent.prototype.match_data = null;
        MessageContent.prototype.odds_data = null;

        MessageContent.create = function create(properties) {
            return new MessageContent(properties);
        };

        MessageContent.encode = function encode(m, w) {
            if (!w)
                w = $protobuf.Writer.create();
            if (m.type != null && Object.hasOwnProperty.call(m, "type"))
                w.uint32(10).string(m.type);
            if (m.matchId != null && Object.hasOwnProperty.call(m, "matchId"))
                w.uint32(16).int64(m.matchId);
            if (m.match_data != null && Object.hasOwnProperty.call(m, "match_data"))
                $root.notification.MatchData.encode(m.match_data, w.uint32(26).fork()).ldelim();
            if (m.odds_data != null && Object.hasOwnProperty.call(m, "odds_data"))
                $root.notification.OddsDataList.encode(m.odds_data, w.uint32(34).fork()).ldelim();
            return w;
        };

        MessageContent.decode = function decode(r, l) {
            if (!(r instanceof $protobuf.Reader))
                r = $protobuf.Reader.create(r);
            var end = l === undefined ? r.len : r.pos + l, m = new $root.notification.MessageContent();
            while (r.pos < end) {
                var t = r.uint32();
                switch (t >>> 3) {
                    case 1:
                        m.type = r.string();
                        break;
                    case 2:
                        m.matchId = r.int64();
                        break;
                    case 3:
                        m.match_data = $root.notification.MatchData.decode(r, r.uint32());
                        break;
                    case 4:
                        m.odds_data = $root.notification.OddsDataList.decode(r, r.uint32());
                        break;
                    default:
                        r.skipType(t & 7);
                        break;
                }
            }
            return m;
        };

        return MessageContent;
    })();

    notification.MatchData = (function() {

        function MatchData(p) {
            if (p)
                for (var ks = Object.keys(p), i = 0; i < ks.length; ++i)
                    if (p[ks[i]] != null)
                        this[ks[i]] = p[ks[i]];
        }

        MatchData.prototype.id = $protobuf.Long ? $protobuf.Long.fromBits(0,0,false) : 0;
        MatchData.prototype.startTime = $protobuf.Long ? $protobuf.Long.fromBits(0,0,false) : 0;
        MatchData.prototype.endTime = null;
        MatchData.prototype.matchStatus = 0;
        MatchData.prototype.statusDesc = "";
        MatchData.prototype.result = "";
        MatchData.prototype.periods = "";
        MatchData.prototype.periodTime = null;
        MatchData.prototype.homeTeamId = $protobuf.Long ? $protobuf.Long.fromBits(0,0,false) : 0;
        MatchData.prototype.homeScore = 0;
        MatchData.prototype.awayTeamId = $protobuf.Long ? $protobuf.Long.fromBits(0,0,false) : 0;
        MatchData.prototype.awayScore = 0;
        MatchData.prototype.updateTime = $protobuf.Long ? $protobuf.Long.fromBits(0,0,false) : 0;

        MatchData.create = function create(properties) {
            return new MatchData(properties);
        };

        MatchData.encode = function encode(m, w) {
            if (!w)
                w = $protobuf.Writer.create();
            if (m.id != null && Object.hasOwnProperty.call(m, "id"))
                w.uint32(8).int64(m.id);
            if (m.startTime != null && Object.hasOwnProperty.call(m, "startTime"))
                w.uint32(16).int64(m.startTime);
            if (m.endTime != null && Object.hasOwnProperty.call(m, "endTime"))
                w.uint32(24).int64(m.endTime);
            if (m.matchStatus != null && Object.hasOwnProperty.call(m, "matchStatus"))
                w.uint32(32).int32(m.matchStatus);
            if (m.statusDesc != null && Object.hasOwnProperty.call(m, "statusDesc"))
                w.uint32(42).string(m.statusDesc);
            if (m.result != null && Object.hasOwnProperty.call(m, "result"))
                w.uint32(50).string(m.result);
            if (m.periods != null && Object.hasOwnProperty.call(m, "periods"))
                w.uint32(58).string(m.periods);
            if (m.periodTime != null && Object.hasOwnProperty.call(m, "periodTime"))
                w.uint32(64).int64(m.periodTime);
            if (m.homeTeamId != null && Object.hasOwnProperty.call(m, "homeTeamId"))
                w.uint32(72).int64(m.homeTeamId);
            if (m.homeScore != null && Object.hasOwnProperty.call(m, "homeScore"))
                w.uint32(80).int32(m.homeScore);
            if (m.awayTeamId != null && Object.hasOwnProperty.call(m, "awayTeamId"))
                w.uint32(88).int64(m.awayTeamId);
            if (m.awayScore != null && Object.hasOwnProperty.call(m, "awayScore"))
                w.uint32(96).int32(m.awayScore);
            if (m.updateTime != null && Object.hasOwnProperty.call(m, "updateTime"))
                w.uint32(104).int64(m.updateTime);
            return w;
        };

        MatchData.decode = function decode(r, l) {
            if (!(r instanceof $protobuf.Reader))
                r = $protobuf.Reader.create(r);
            var end = l === undefined ? r.len : r.pos + l, m = new $root.notification.MatchData();
            while (r.pos < end) {
                var t = r.uint32();
                switch (t >>> 3) {
                    case 1:
                        m.id = r.int64();
                        break;
                    case 2:
                        m.startTime = r.int64();
                        break;
                    case 3:
                        m.endTime = r.int64();
                        break;
                    case 4:
                        m.matchStatus = r.int32();
                        break;
                    case 5:
                        m.statusDesc = r.string();
                        break;
                    case 6:
                        m.result = r.string();
                        break;
                    case 7:
                        m.periods = r.string();
                        break;
                    case 8:
                        m.periodTime = r.int64();
                        break;
                    case 9:
                        m.homeTeamId = r.int64();
                        break;
                    case 10:
                        m.homeScore = r.int32();
                        break;
                    case 11:
                        m.awayTeamId = r.int64();
                        break;
                    case 12:
                        m.awayScore = r.int32();
                        break;
                    case 13:
                        m.updateTime = r.int64();
                        break;
                    default:
                        r.skipType(t & 7);
                        break;
                }
            }
            return m;
        };

        return MatchData;
    })();

    notification.OddsDataList = (function() {

        function OddsDataList(p) {
            this.data = [];
            if (p)
                for (var ks = Object.keys(p), i = 0; i < ks.length; ++i)
                    if (p[ks[i]] != null)
                        this[ks[i]] = p[ks[i]];
        }

        OddsDataList.prototype.data = $util.emptyArray;

        OddsDataList.create = function create(properties) {
            return new OddsDataList(properties);
        };

        OddsDataList.encode = function encode(m, w) {
            if (!w)
                w = $protobuf.Writer.create();
            if (m.data != null && m.data.length)
                for (var i = 0; i < m.data.length; ++i)
                    $root.notification.OddsData.encode(m.data[i], w.uint32(10).fork()).ldelim();
            return w;
        };

        OddsDataList.decode = function decode(r, l) {
            if (!(r instanceof $protobuf.Reader))
                r = $protobuf.Reader.create(r);
            var end = l === undefined ? r.len : r.pos + l, m = new $root.notification.OddsDataList();
            while (r.pos < end) {
                var t = r.uint32();
                switch (t >>> 3) {
                    case 1:
                        if (!(m.data && m.data.length))
                            m.data = [];
                        m.data.push($root.notification.OddsData.decode(r, r.uint32()));
                        break;
                    default:
                        r.skipType(t & 7);
                        break;
                }
            }
            return m;
        };

        return OddsDataList;
    })();

    notification.OddsData = (function() {

        function OddsData(p) {
            if (p)
                for (var ks = Object.keys(p), i = 0; i < ks.length; ++i)
                    if (p[ks[i]] != null)
                        this[ks[i]] = p[ks[i]];
        }

        OddsData.prototype.code = "";
        OddsData.prototype.value = 0;
        OddsData.prototype.status = 0;
        OddsData.prototype.updateTime = $protobuf.Long ? $protobuf.Long.fromBits(0,0,false) : 0;

        OddsData.create = function create(properties) {
            return new OddsData(properties);
        };

        OddsData.encode = function encode(m, w) {
            if (!w)
                w = $protobuf.Writer.create();
            if (m.code != null && Object.hasOwnProperty.call(m, "code"))
                w.uint32(10).string(m.code);
            if (m.value != null && Object.hasOwnProperty.call(m, "value"))
                w.uint32(17).double(m.value);
            if (m.status != null && Object.hasOwnProperty.call(m, "status"))
                w.uint32(24).int32(m.status);
            if (m.updateTime != null && Object.hasOwnProperty.call(m, "updateTime"))
                w.uint32(32).int64(m.updateTime);
            return w;
        };

        OddsData.decode = function decode(r, l) {
            if (!(r instanceof $protobuf.Reader))
                r = $protobuf.Reader.create(r);
            var end = l === undefined ? r.len : r.pos + l, m = new $root.notification.OddsData();
            while (r.pos < end) {
                var t = r.uint32();
                switch (t >>> 3) {
                    case 1:
                        m.code = r.string();
                        break;
                    case 2:
                        m.value = r.double();
                        break;
                    case 3:
                        m.status = r.int32();
                        break;
                    case 4:
                        m.updateTime = r.int64();
                        break;
                    default:
                        r.skipType(t & 7);
                        break;
                }
            }
            return m;
        };

        return OddsData;
    })();

    return notification;
})();

module.exports = $root;