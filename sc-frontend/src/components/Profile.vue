<template>
  <div>
    <div class="content-wrapper" id="form-create">
      <div class="content">
        <div class="content-form">
          <div class="form">
            <div class="form-title color: #E2526D">
              <img src="../assets/profile-icons/profile-tytle.png" style="height: 60px; width: 320px"/>
            </div>

            <div class="form-body">

              <div class="input-location">
                <span class="input-name 4 i-location">  </span>
                <input type="text" placeholder="Location" disabled v-model="response.country"/>
              </div>

              <div class="input-mail">
                <span class="input-name 4 i-mail"></span>
                <input disabled type="text" placeholder="Email address" v-model="response.email"/>
              </div>

              <div class="input-l">
                <span class="input-name 4 i-name">  </span>
                <input type="text" placeholder="Name" v-model="name"/>
              </div>

              <div class="input-loc">
                <span class="input-name 4 i-city">  </span>
                <input type="text" placeholder="City" v-model="loc"/>
              </div>

              <div class="input-number">
                <span class="input-name 4 i-phone"></span>
                <input type="text" placeholder="Contact Number" v-model="contact"/>
              </div>

              <div class="input-about">
                <span class="input-name 4 i-about"></span>
                <input type="textarea" placeholder="About You" v-model="about"/>
              </div>

              <div class="input-skills">
                <span class="input-name 4 i-skill"></span>
                <input type="text" placeholder="Your skills" v-model="skills"/>
              </div>
            </div>
          </div>
        </div>
        <div class="content-profile">
          <div class="profile-head">
            <div class="profile-pic">

            </div>
            <div class="profile-location">{{ response.country }}</div>

            <div class="profile-loc">
              <div><i class="material-icons" style="color: #46804D ">location_on</i></div>
              <div>{{ loc }}</div>
            </div>
          </div>
          <div class="profile-info">
            <div class="profile-name">{{ name }}</div>
            <div class="profile-skills">{{ skills }}</div>
            <div class="profile-about">
              {{ about }}
            </div>
            <div class="profile-info-sub">
              <div class="profile-mail">{{ response.email }}</div>
              <div class="profile-contact">{{ contact }}</div>
            </div>
          </div>
        </div>
        <input readonly @click="save()" type="button" title="Save"/>
      </div>

    </div>
    <div class="fullscreen-bg"></div>
  </div>

</template>

<script>
  import {AXIOS} from "./http-common";

  export default {
    name: 'profile',

    data() {
      return {
        name: "",
        loc: "",
        about: "",
        contact: "",
        skills: "",
        image: "",
        response: {}
      }
    },
    methods: {
      save() {
        AXIOS.post(`/main/profile/save`, {
          name: this.name,
          city: this.loc,
          phone: this.contact,
          skills: this.skills,
          about_me: this.about,
        })
          .then(response => {
            // JSON responses are automatically parsed.
            //   this.user.id = response.data;
            console.log(response.status);
            // this.user.username=response.userName;
            // this.showResponse = true
          })
          .catch(e => {
            this.error = true;
          })
      }
    },
    created() {


      AXIOS.get(`/main/profile/getInfo`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.response = response.data;

          //   this.user.id = response.data;
          console.log(response);
          // this.user.username=response.userName;
          // this.showResponse = true
        })
        .catch(e => {
          this.error = true;
        })

    }

  }
</script>

<style lang="scss">
  @import url('https://fonts.googleapis.com/css?family=Patrick+Hand');

  /*.icon-profile  {*/
  /*background: url("../../assets/sidebar-icons/profile.png") 95% no-repeat;*/
  /*background-size: 40px;*/
  /*}*/

  /*.fa-2x {*/
  /*font-size: 2em;*/
  /*}*/
  /*.fa {*/
  /*position: relative;*/
  /*padding-right: 0px;*/
  /*display: table-cell;*/
  /*width: 60px;*/
  /*height: 50px;*/
  /*text-align: center;*/
  /*vertical-align: middle;*/
  /*font-size:20px;*/

  /*}*/

  body {

    p {
      font-family: 'GlacialIndifferenceRegular', serif;
      font-weight: normal;
      font-style: normal;
    }

    padding: 0;
    margin: 0;
    width: 100%;
    height: 100%;
    box-sizing: border-box;
    vertical-align: middle;

    input[type="button"] {
      background: url("../assets/profile-icons/button-save.png") no-repeat top;
      background-size: cover;
      border: 0px;
      display: block;
      width: 300px;
      height: 200px;
      line-height: 100px;
      margin: auto;
      color: #fff;
      position: absolute;
      top: 500px;
      bottom: 0;
      left: 0;
      right: 0;
      cursor: pointer;
      overflow: hidden;

    }

    /*.button-save {*/
    /*width: 300px;*/
    /*height: 100px;*/
    /*background-size: cover;*/
    /*!*background: url(здесь УРЛ изображения) top left no-repeat;*!*/

    /*}*/

    .hidden {
      display: none;
    }
    .abs-hidden-l-t {
      position: absolute;
      top: 0;
      left: 0;
      visibility: shown;
    }
    .content-wrapper {

      .content {
        display: flex;
        flex-direction: row;
        margin: 4% auto;
        align-items: center;
        justify-content: center;
        height: 100%;
        @media screen and (max-width: 959px) {
          flex-direction: column;
          justify-content: center;
          align-content: center;
          & .content-form {
            max-width: 400px;
            margin: 0 24px;
          }
        }

        .form {
          padding: 100px;
          padding-bottom: 130px;
          margin-right: 16px;
          min-width: 400px;
          .form-title {
            font-size: 42px;
            margin-bottom: 16px;
          }
          input {
            padding: 0px 0px 0px 10px;
            background: transparent;
            min-height: 40px;
            width: 100%;
            max-width: 250px;
            outline: none;
            font-size: 16px;
            margin: 4px 0;
            border: 0;
            border-bottom: 2px solid rgba(0, 150, 136, 0.4);
            transition: 0.2s ease-in-out;
            &:focus {
              border-bottom: 2px solid rgba(24, 124, 190, 0.9);
              transform: scale(1.02);
            }
          }
        }
        .content-profile {
          max-width: 350px;
          min-height: 450px;
          width: 100%;
          box-shadow: 0 0 23px #b1b1b1;
          background-color: #0EB3F3;
          background-size: cover;
          padding: 0 0 0% 0;

          border-radius: 4px;
          .profile-head {
            max-height: 40%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 8% 0 25% 0;
            background: url("../assets/profile-icons/globe.png") center;
            background-size: cover;
            font-family: 'GlacialIndifferenceRegular', serif;
            .profile-pic {
              margin-bottom: 8px;
              img {
                height: 140px;
                width: 140px;
                border-radius: 5em;
                box-shadow: 0 2px 4px #b1b1b1;
                object-fit: cover;
              }
            }
            .profile-name {
              font-size: 24px;

            }
            .profile-loc {
              font-size: 14px;
              color: black;
              display: flex;
              align-items: center;
              font-family: 'GlacialIndifferenceRegular', serif;
            }
          }
          .profile-info {
            font-family: 'GlacialIndifferenceRegular', serif;
            padding: 16px;
            padding-bottom: 0;
            font-color: #FFB300;

            border-radius: 4px;

            .profile-skills {
              text-align: center;
              margin: 0 auto 4% auto;
            }
            .profile-about {
              height: 150px;
              margin: auto;
              border: 3px solid #FFE550;
              background-color: #B0DCF3;
              padding: 8px;
              margin: 16px 0;
              line-height: 24px;
              text-align: center;
            }
            .profile-info-sub {
              display: flex;
              justify-content: space-between;
              font-family: 'GlacialIndifferenceRegular', serif;
            }
          }
          .profile-footer {
            text-align: center;
            font-size: 14px;
            opacity: 0.4;
            font-weight: bold;
            padding: 14px;
            i {
              position: relative;
              bottom: -3px;
              font-size: 14px;
            }
          }
        }
      }
    }
  }

  .fullscreen-bg {
    position: fixed;
    z-index: -1;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;

    background: url("../assets/profile-icons/profile-bg.png") center;
    background-size: cover;
  }

  .i-location {
    /*margin: 13px 0px 0px 15px;*/
    position: relative;
    float: left;
    height: 20px;
    width: 20px;
    background: url("../assets/profile-icons/point.png") 95% no-repeat;
    background-size: cover;

    color: #333;
    padding: 11px 4px;
    margin-right: 20px;
    /*background-position: center;*/
  }

  .i-name {
    /*margin: 13px 0px 0px 15px;*/
    position: relative;
    float: left;
    height: 20px;
    width: 20px;
    background: url("../assets/profile-icons/name.png") 95% no-repeat;
    background-size: cover;
    margin-right: 15px;
    margin-top: 5px;
    color: #333;
    padding: 7px 6px;

  }

  .i-city {
    /*margin: 13px 0px 0px 15px;*/
    position: relative;
    float: left;
    height: 20px;
    width: 20px;
    background: url("../assets/profile-icons/city.png") 95% no-repeat;
    background-size: cover;
    margin-right: 18px;
    color: #333;
    padding: 11px 4px;

  }

  .i-mail {
    /*margin: 13px 0px 0px 15px;*/
    position: relative;
    float: left;
    height: 20px;
    width: 20px;
    background: url("../assets/profile-icons/e-mail.png") 95% no-repeat;
    background-size: cover;
    margin-top: 5px;
    color: #333;
    padding: 6px 5px;
    margin-right: 16px;

  }

  .i-phone {
    /*margin: 13px 0px 0px 15px;*/
    position: relative;
    float: left;
    height: 20px;
    width: 20px;
    background: url("../assets/profile-icons/phone.png") 95% no-repeat;
    background-size: cover;
    margin-right: 13px;
    margin-top: 5px;
    color: #333;
    padding: 6px 7px;

  }

  .i-about {
    /*margin: 13px 0px 0px 15px;*/
    position: relative;
    float: left;
    height: 20px;
    width: 20px;
    background: url("../assets/profile-icons/about-1.png") 95% no-repeat;
    background-size: cover;
    color: #333;
    padding: 5px 8px;
    margin-right: 12px;
    margin-top: 5px;

  }

  .i-skill {
    /*margin: 13px 0px 0px 15px;*/
    position: relative;
    float: left;
    height: 20px;
    width: 20px;
    background: url("../assets/profile-icons/skill.png") 95% no-repeat;
    background-size: cover;
    color: #333;
    padding: 5px 8px;
    margin-right: 11px;
    margin-top: 5px;

  }


</style>
