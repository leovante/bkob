
  <!--<div>-->
    <!--<div id="main-content" class="container">-->
      <!--<div class="row">-->
        <!--<div class="col-md-6">-->
          <!--<form class="form-inline">-->
            <!--<div class="form-group">-->
              <!--<label for="connect">WebSocket connection:</label>-->
              <!--<button id="connect" class="btn btn-default" type="submit" :disabled="connected == true" @click.prevent="connect">Connect</button>-->
              <!--<button id="disconnect" class="btn btn-default" type="submit" :disabled="connected == false" @click.prevent="disconnect">Disconnect-->
              <!--</button>-->
            <!--</div>-->
          <!--</form>-->
      <!--<div class="container">-->
        <!--<div class="header">-->
          <!--Simple chat-->
        <!--</div>-->
        <!--<div class="chat-container">-->
          <!--<ul class="chat" id="chat"></ul>-->
        <!--</div>-->

        <!--<input type="text" placeholder="Type text & hit enter" maxlength="200" id="input">-->
      <!--</div>-->
      <!--&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;-->
        <!--</div>-->
        <!--<div class="col-md-6">-->
          <!--<form class="form-inline">-->
            <!--<div class="form-group">-->
              <!--<label for="name">What is your name?</label>-->
              <!--<input type="text" id="name" class="form-control" v-model="send_message" placeholder="Your name here...">-->
            <!--</div>-->
            <!--<button id="send" class="btn btn-default" type="submit" @click.prevent="send">Send</button>-->
          <!--</form>-->
        <!--</div>-->
      <!--</div>-->
      <!--<div class="row">-->
        <!--<div class="col-md-12">-->
          <!--<table id="conversation" class="table table-striped">-->
            <!--<thead>-->
            <!--<tr>-->
              <!--<th>Greetings</th>-->
            <!--</tr>-->
            <!--</thead>-->
            <!--<tbody>-->
            <!--<tr v-for="item in received_messages" :key="item">-->
              <!--<td>{{ item }}</td>-->
            <!--</tr>-->
            <!--</tbody>-->
          <!--</table>-->
        <!--</div>-->
      <!--</div>-->
 <template>
<div>
  <div class="chat">
    <div class="chat-title">
      <h1 style="color: black">Bkob</h1>
      <h2>CHAT</h2>
      <figure class="avatar">
        <img src="./../assets/bkob-logo.png" /></figure>
    </div>
    <div class="messages">

      <div class="messages-content" v-for="item in received_messages" :key="item">
        <tbody>
      <tr v-for="item in received_messages" :key="item">
        <td>{{ item }}</td>
      </tr>
      </tbody>
      </div>

    </div>
    <div class="message-box">
      <textarea type="text" class="message-input" @keyup.enter="send(); send_message=null;"  v-model="send_message" placeholder="Type message..."></textarea>
      <button type="submit" class="message-submit" @click.prevent="send">Send</button>
    </div>

  </div>
  <div class="bg"></div>
</div>

</template>

<script>
  import SockJS from "sockjs-client";
  import Stomp from "webstomp-client";
  export default {
    name: "websocketdemo",
    data() {
      return {
        received_messages:[]
         ,
        send_message: null,
        connected: true,
        user: {
          name: ''
        },
      };
    },
    methods: {

      send() {

        var params = new URLSearchParams();
        params.append('firstName', this.user.firstName);

        AXIOS.get(`/hello`, params)
          .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data;
            //   this.user.id = response.data;
            console.log(response.data);
            this.showResponse = true
          })
          .catch(e => {
            this.errors.push(e)
          });


        console.log("Send message:" + this.send_message);
        if (this.stompClient && this.stompClient.connected) {
          const msg = { name: this.send_message.trim()};
          this.stompClient.send("/app/hello",JSON.stringify(msg), {});
        }
      },
      connect() {
        this.socket = new SockJS("http://localhost:8080/gs-guide-websocket");
        this.stompClient = Stomp.over(this.socket);
        this.stompClient.connect(
          {},
          frame => {
          this.connected = true;
        console.log(frame);
        this.stompClient.subscribe("/topic/greetings", tick => {
          console.log(tick);
        this.received_messages.push(JSON.parse(tick.body).content);
      });
      },
        error => {
          console.log(error);
          this.connected = false;
        }
      );
      },
      disconnect() {
        if (this.stompClient) {
          this.stompClient.disconnect();
        }
        this.connected = false;
      },
      tickleConnection() {
        this.connected ? this.disconnect() : this.connect();
      }
    },
    mounted() {
       this.connect();
    }
  };
</script>



<style lang="scss">

  @mixin center {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }

  @mixin ball {
    @include center;
    content: '';
    display: block;
    width: 3px;
    height: 3px;
    border-radius: 50%;
    background: rgba(255, 255, 255, .5);
    z-index: 2;
    margin-top: 4px;
    animation: ball .45s cubic-bezier(0, 0, 0.15, 1) alternate infinite;
  }


  /*--------------------
  Body
  --------------------*/
  *,
  *::before,
  *::after {
    box-sizing: border-box;
  }

  html,
  body {
    height: 100%;
  }

  body {
    background-image:url("./../assets/bg.jpg");
    background-size: cover;
    font-family: 'Open Sans', sans-serif;
    font-size: 12px;
    line-height: 1.3;
    overflow: hidden;
  }

  .bg {
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    z-index: 1;
     filter: blur(80px);
    transform: scale(1.2);
  }


  /*--------------------
  Chat
  --------------------*/
  .chat {
    @include center;
    width: 700px;
    height: 1300px;
    max-height: 500px;
    z-index: 2;
    overflow: hidden;
    background: rgb(29, 152, 131);
    box-shadow: 0 5px 30px rgba(0, 0, 0, .2);
     border-radius: 20px;
    display: flex;
    justify-content: space-between;
    flex-direction: column;
  }


  /*--------------------
  Chat Title
  --------------------*/
  .chat-title {
    flex: 0 1 45px;
    position: relative;
    z-index: 2;
    background: rgb(33, 180, 154);

    color:rgb(225, 119, 121) ;
    text-transform: uppercase;
    text-align: left;
    padding: 10px 10px 10px 50px;

    h1, h2 {
      font-weight: normal;
      font-size: 10px;
      margin: 0;
      padding: 0;
    }

    h2 {
      color:   rgb(225, 119, 121) ;

      font-size: 8px;
      letter-spacing: 1px;
    }

    .avatar {
      position: absolute;
      z-index: 1;
      top: 4px;
      left: 7px;
      border-radius: 30px;
      width: 40px;
      height: 40px;
      overflow: hidden;
      margin: 0;
      padding-left:4px;
      padding-top: 3px;
      border: none;
      img {
        width: 90%;
        height: 90%;
      }
    }
  }


  /*--------------------
  Messages
  --------------------*/
  .messages {
    flex: 1 1 auto;
    color: rgba(255, 255, 255, .5);
    overflow: hidden;
    position: relative;
    width: 100%;

    & .messages-content {
      position: absolute;
      top: 0;
      left: 0;
      height: 101%;
      width: 100%;
    }


    .message {
      clear: both;
      float: left;
      padding: 6px 10px 7px;
      border-radius: 10px 10px 10px 0;
      background: rgba(12, 12, 17, 0.84);
      margin: 8px 0;
      font-size: 11px;
      line-height: 1.4;
      margin-left: 35px;
      position: relative;
      text-shadow: 0 1px 1px rgba(0, 0, 0, .2);

      .timestamp {
        position: absolute;
        bottom: -15px;
        font-size: 9px;
        color: rgba(255, 255, 255, .3);
      }

      &::before {
        content: '';
        position: absolute;
        bottom: -6px;
        border-top: 6px solid rgba(0, 0, 0, .3);
        left: 0;
        border-right: 7px solid transparent;
      }

      .avatar {
        position: absolute;
        z-index: 1;
        bottom: -15px;
        left: -35px;
        border-radius: 30px;
        width: 30px;
        height: 30px;
        overflow: hidden;
        margin: 0;
        padding: 0;
        border: 2px solid rgba(255, 255, 255, 0.24);

        img {
          width: 100%;
          height: auto;
        }
      }

      &.message-personal {
        float: right;
        color: #fff;
        text-align: right;
        background: linear-gradient(120deg, #666869, #171d21);
        border-radius: 10px 10px 0 10px;

        &::before {
          left: auto;
          right: 0;
          border-right: none;
          border-left: 5px solid transparent;
          border-top: 4px solid #666869;
          bottom: -4px;
        }
      }

      &:last-child {
        margin-bottom: 30px;
      }

      &.new {
        transform: scale(0);
        transform-origin: 0 0;
        animation: bounce 500ms linear both;
      }

      &.loading {

        &::before {
          @include ball;
          border: none;
          animation-delay: .15s;
        }

        & span {
          display: block;
          font-size: 0;
          width: 20px;
          height: 10px;
          position: relative;

          &::before {
            @include ball;
            margin-left: -7px;
          }

          &::after {
            @include ball;
            margin-left: 7px;
            animation-delay: .3s;
          }
        }
      }

    }
  }


  /*--------------------
  Message Box
  --------------------*/
  .message-box {
    flex: 0 1 40px;
    width: 100%;
    background: rgb(255, 119, 121);
    padding: 10px;
    position: relative;

    & .message-input {
      background: none;
      border: none;
      outline: none!important;
      resize:none;
      color: red;
      font-size: 16px;
      margin: 0;
      padding-right: 20px;
      width: 40%;

    }

    input {
      outline: none;
      word-break: break-all;
      white-space: normal;
      width:100px
    }
    textarea:focus::-webkit-input-placeholder {
      outline: none;
      resize: none;
      overflow: hidden;
      word-wrap: break-spaces;
      color: transparent;
    }

    & .message-submit {
      position: absolute;
      z-index: 1;
      top: 9px;
      right: 10px;
      color: #bcbebf;
      border: none;
      background: red;
      font-size: 10px;
      text-transform: uppercase;
      line-height: 1;
      padding: 6px 10px;
      border-radius: 10px;
      outline: none!important;
      transition: background .2s ease;

      &:hover {
        background: rgb(90,164,225);
      }
    }
  }


  /*--------------------
  Custom Srollbar
  --------------------*/
  .mCSB_scrollTools {
    margin: 1px -3px 1px 0;
    opacity: 0;
  }

  .mCSB_inside > .mCSB_container {
    margin-right: 0px;
    padding: 0 10px;
  }

  .mCSB_scrollTools .mCSB_dragger .mCSB_dragger_bar {
    background-color: rgba(0, 0, 0, 0.5)!important;
  }


  /*--------------------
  Bounce
  --------------------*/
  @keyframes bounce {
    0% { transform: matrix3d(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    4.7% { transform: matrix3d(0.45, 0, 0, 0, 0, 0.45, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    9.41% { transform: matrix3d(0.883, 0, 0, 0, 0, 0.883, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    14.11% { transform: matrix3d(1.141, 0, 0, 0, 0, 1.141, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    18.72% { transform: matrix3d(1.212, 0, 0, 0, 0, 1.212, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    24.32% { transform: matrix3d(1.151, 0, 0, 0, 0, 1.151, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    29.93% { transform: matrix3d(1.048, 0, 0, 0, 0, 1.048, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    35.54% { transform: matrix3d(0.979, 0, 0, 0, 0, 0.979, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    41.04% { transform: matrix3d(0.961, 0, 0, 0, 0, 0.961, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    52.15% { transform: matrix3d(0.991, 0, 0, 0, 0, 0.991, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    63.26% { transform: matrix3d(1.007, 0, 0, 0, 0, 1.007, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    85.49% { transform: matrix3d(0.999, 0, 0, 0, 0, 0.999, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
    100% { transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  }


  @keyframes ball {
    from {
      transform: translateY(0) scaleY(.8);
    }
    to {
      transform: translateY(-10px);
    }
  }


</style>
