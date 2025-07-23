# WebSocket Protobuf 客户端示例

这个项目演示了如何使用Node.js创建WebSocket客户端，接收压缩的Protobuf消息，并进行解压和解析。

## 功能特点

- 使用WebSocket连接服务器
- 接收Zstandard压缩的二进制数据
- 解压数据并解析为Protobuf对象
- 根据消息类型处理不同的数据

## 项目结构

```
├── pb/
│   └── notification.js     # Protobuf生成的JavaScript文件
├── websocket/
│   └── ws.js               # WebSocket客户端实现
└── examples/
    └── ws-client-example.js # 使用示例
```

## 安装依赖

```bash
npm install
```

## 使用方法

1. 修改示例文件中的WebSocket服务器地址：

```javascript
// 在 examples/ws-client-example.js 中
const wsServerUrl = 'ws://your-websocket-server-url' // 替换为实际的服务器地址
```

2. 运行示例：

```bash
node examples/ws-client-example.js
```

## 在其他项目中使用

```javascript
const { connectWebSocket } = require('./websocket/ws')

// 连接WebSocket服务器
const ws = await connectWebSocket('ws://your-websocket-server-url')

// 连接成功后，客户端会自动处理接收到的消息
// 包括解压、解析Protobuf和根据消息类型进行处理
```

## 依赖项

- ws: WebSocket客户端
- fzstd: Zstandard压缩/解压库
- protobufjs: Protocol Buffers库（通过notification.js间接使用）