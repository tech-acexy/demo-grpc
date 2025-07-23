const WebSocket = require('ws')
const {
    NotificationMessageFactory,
    MatchDataHelper,
    OddsDataHelper
} = require('../pb/notification_pb');
const {decompress} = require('fzstd')

// WebSocket客户端连接
const connectWebSocket = (url) => {
    return new Promise((resolve, reject) => {
        const ws = new WebSocket(url)

        ws.on('open', () => {
            console.log('WebSocket连接已建立')
            resolve(ws)
        })

        ws.on('error', (error) => {
            console.error('WebSocket连接错误:', error)
            reject(error)
        })

        ws.on('close', () => {
            console.log('WebSocket连接已关闭')
        })

        // 接收消息处理
        ws.on('message', async (data) => {
            try {
                // 1. 解压数据
                const decompressed = decompress(data)
                // 2. 解析为Protobuf对象
                const message = NotificationMessageFactory.decode(decompressed)

                console.log(message.toJSON());
                // 根据消息类型处理不同的数据
                if (message.match_data) {
                    console.log('比赛数据:', message.match_data)
                } else if (message.odds_data) {
                    console.log('赔率数据:', message.odds_data)
                }
            } catch (error) {
                console.error('处理消息错误:', error)
            }
        })
    })
}

// 使用示例
const main = async () => {
    try {
        // 替换为实际的WebSocket服务器地址
        const ws = await connectWebSocket('wss://ws.dev.ccsccorp.com/api/notification/websocket?deviceId=BB017ECF4BE34BBFA3B7F09A29CEB419&p=631b1b4f8ca3a886e1983807ff9670ebef9d194d27b16a6405f74cf6980099ab&t=1753266821000')

        // 可以在这里添加其他逻辑，如发送消息等
    } catch (error) {
        console.error('连接WebSocket服务器失败:', error)
    }
}

main()
