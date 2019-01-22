
<template >
  <div class="loading " v-if="!done" v-model="setDone">
    <img class="logo framed loadingInAnim" v-if=""  src="../../assets/bkob-logo.png" alt="Bkob logo"/>
  </div>

  <div v-else>
<div class="grid"v-show="done">
  <div class="sabgrid2">
  <div class="header sticky sticky--top js-header">LOGO</div>
    <div>Header</div>

  <!--<div>Sub-2</div>-->
  <!--<div>Sub-3</div>-->
</div>
    <!--<div class="subitems">-->
      <!--<div>Sub-1</div>-->
      <!--<div>Sub-2</div>-->
    <!--</div>-->
    <!--<div class="subitems">-->
      <!--<div class = subitems3>-->
        <!--<div  >Home</div>-->
        <!--<div >Profile</div>-->
        <!--<div >Messages</div>-->
        <!--<div >Friends</div>-->
        <!--<div >Rating</div>-->
        <!--<div >Constructor</div>-->
      <!--</div>-->
      <!--<div>Sub-2</div>-->
    <!--</div>-->
</div>






  <div class="subitems">
    <div><div class="area"></div><nav class="main-menu">
      <ul>

        <li class="has-subnav">
          <a href="/main/profile">
            <i class="fa icon-profile fa-2x"></i>
            <span class="nav-text">
                            Profile
                        </span>
          </a>
        </li>
        <li class="has-subnav">
          <a href="#">
            <i class="fa icon-message  fa-2x"></i>
            <span class="nav-text">
                            Message
                        </span>
          </a>

        </li>
        <li class="has-subnav">
          <a href="#">
            <i class="fa icon-friends fa-2x"></i>
            <span class="nav-text">
                            Friends
                        </span>
          </a>

        </li>
        <li class="has-subnav">
          <a href="#">
            <i class="fa icon-cryptocell fa-2x"></i>
            <span class="nav-text">
                            Cryptocell
                        </span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="fa icon-groups ifa-2x"></i>
            <span class="nav-text">
                            Groups
                        </span>
          </a>
        </li>


        <li>
          <a href="#">
            <i class="fa icon-forum fa-2x"></i>
            <span class="nav-text">
                            Forum
                        </span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="fa icon-constructor fa-2x"></i>
            <span class="nav-text">
                           Constructor
                        </span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="fa icon-rating fa-2x"></i>
            <span class="nav-text">
                            Rating
                        </span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="fa icon-freelance fa-2x"></i>
            <span class="nav-text">
                            Freelance
                        </span>
          </a>
        </li>

        <li>
          <a href="#">
            <i class="fa icon-documents fa-2x"></i>
            <span class="nav-text">
                            Documents
                        </span>
          </a>
        </li>

        <li>
          <a href="#">
            <i class="fa icon-settrings ifa-2x"></i>
            <span class="nav-text">
                            Settings
                        </span>
          </a>
        </li>

        <li>
          <a href="#">
            <i class="fa icon-support ifa-2x"></i>
            <span class="nav-text">
                            Support
                        </span>
          </a>
        </li>

        <li>
          <a href="#">
            <i class="fa icon-logout fa-2x"></i>
            <span class="nav-text">
                            Logout
                        </span>
          </a>
        </li>

      </ul>

    </nav>
    </div>

  <div class="fullscreen-bg"></div>

  </div>
  </div>
</template>

<script>


  import {AXIOS} from './../http-common'

  import Header from "./Header";
  export default {
    name: "main.vue",
    components: {Header},
    data(){
      return{
        done:false
      }
    },
    methods:{
      setDone(){
        this.done=true;

      },

    },
    mounted(){
      setTimeout(this.setDone, 5500);
      console.log("tokenn"+this.$store.getters.token);
    }
  }

</script>

<style scoped>


/*.grid {*/
  /*display: grid;*/
  /*grid-template-columns: 1fr;*/
  /*grid-gap: 4px;*/
 /*}*/


.grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 4px;
}


/*.grid div  {*/


    /*border: 1px solid #00a8e6;*/
  /*!*background-color: #0b97c4;*!*/
    /*padding: 8px 15px;*/
    /*color: #ffffff;*/
    /*font-size: 18px;*/
    /*font-family: Roboto;*/
  /*}*/

.framed {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 15rem;
  margin-left: -7.5rem;
}
.logo {
  margin-top: -22em;
  cursor: default;
}
.loading{
  display: block;
  position:absolute;
  z-index: -1;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background: url("../../assets/485654-PH172E-105.jpg") center;
  background-size: cover;
}
/*.grid div {*/
  /*background-color: #0b97c4;*/
  /*border: 1px solid #00a8e6;*/
  /*border-radius: 5px;*/
  /*padding: 8px 15px;*/
  /*color: #ffffff;*/
  /*font-size: 18px;*/
  /*font-family: Roboto;*/
/*}*/

/*.grid div.sabgrid2 {*/
  /*display: grid;*/
  /*!*background-color: #c45fb8;*!*/
  /*border: 1px solid #c45fb8;*/
  /*grid-template-columns: repeat(3, 1fr);*/
  /*grid-gap: 4px;*/

/*}*/

/*.grid div.sabgrid2 div:nth-child(1) {*/
  /*grid-column: 1 /-1 ;*/
  /*grid-row: 1/ 1 ;*/
  /*grid-gap: 10px;*/
  /*!*background-color: aqua;*!*/
/*}*/
/*.grid div.subitems3*/
/*{*/
  /*display: grid;*/
  /*grid-template-rows: repeat(6, 1fr);*/
  /*grid-gap: 4px;*/

/*}*/

/*.grid div.subitems3 div {*/
  /*!*background-color: #2fc495;*!*/
  /*!*border: 1px solid #00a8e6;*!*/
/*}*/


/*.grid div.subitems {*/
  /*display: grid;*/

/*}*/

/*.grid div.subitems div {*/

   /*!*background-color: darkslateblue;*!*/
 /*}*/

.fullscreen-bg {
  position: fixed;
  z-index: -1;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background: url("../../assets/485654-PH172E-105.jpg") center;
  background-size: cover;
}

</style>

<style scoped>

  .icon-profile  {
    background: url("../../assets/sidebar-icons/profile.png") 95% no-repeat;
    background-size: 40px;
  }

  .icon-message  {
    background: url("../../assets/sidebar-icons/message.png") 95% no-repeat;
    background-size: 40px;
  }

  .icon-friends  {
    background: url("../../assets/sidebar-icons/friends.png") 95% no-repeat;
    background-size: 40px;
  }

  .icon-cryptocell  {
       background: url("../../assets/sidebar-icons/crypto.png") 95% no-repeat;
       background-size: 40px;
     }

  .icon-forum  {
    background: url("../../assets/sidebar-icons/forum-3.png") 95% no-repeat;
    background-size: 40px;
  }

  .icon-groups {
    background: url("../../assets/sidebar-icons/groups.png") 95% no-repeat;
    background-size: 40px;
  }

  .icon-constructor {
    background: url("../../assets/sidebar-icons/consructor.png") 95% no-repeat;
    background-size: 40px;
  }

  .icon-rating {
    background: url("../../assets/sidebar-icons/rating.png") 95% no-repeat;
    background-size: 40px;
  }



  .icon-freelance {
    background: url("../../assets/sidebar-icons/freelance.png") 95% no-repeat;
    background-size: 40px;
  }

  .icon-documents {
    background: url("../../assets/sidebar-icons/docs.png") 95% no-repeat;
    background-size: 40px;
  }

  .icon-settrings {
    background: url("../../assets/sidebar-icons/settings.png") 95% no-repeat;
    background-size: 40px;
  }

  .icon-support {
    background: url("../../assets/sidebar-icons/support.png") 95% no-repeat;
    background-size: 40px;
  }

  .icon-logout {
    background: url("../../assets/sidebar-icons/exit.png") 95% no-repeat;
    background-size: 40px;
  }








  .fa-2x {
    font-size: 2em;
  }
  .fa {
    position: relative;
    /*padding-right: 20px;*/
    display: table-cell;
    width: 60px;
    height: 50px;
    text-align: center;
    vertical-align: middle;
    font-size:20px;
  }


  .main-menu:hover,nav.main-menu.expanded {
    width:250px;
    overflow:visible;
  }

  .main-menu {
    background: #e5e5e5;
    background-size: cover;
    border-right:1px solid #e5e5e5;
    position:absolute;
    top:0;
    bottom:0;
    height:100%;
    left:0;
    width:60px;
    overflow:hidden;
    -webkit-transition:width .05s linear;
    transition:width .05s linear;
    -webkit-transform:translateZ(0) scale(1,1);
    z-index:1000;

  }

  .main-menu>ul {
    margin:7px 0;

  }

  .main-menu li {
    position:relative;
    display:block;
    width:250px;

  }

  .main-menu li>a {
    position:relative;
    display:table;
    border-collapse:collapse;
    border-spacing:0;
    color:#999;
    font-family: arial;
    font-size: 14px;
    text-decoration:none;
    -webkit-transform:translateZ(0) scale(1,1);
    -webkit-transition:all .1s linear;
    transition:all .1s linear;


  }



  .main-menu .nav-text {
    position:relative;
    display:table-cell;
    vertical-align:middle;
    width:190px;
    font-family: 'Titillium Web', sans-serif;
    padding-left: 50px;
  }

  .main-menu>ul.logout {
    position:absolute;
    left:0;
    bottom:0;
  }

  a:hover,a:focus {
    text-decoration:none;
  }

  nav {
    -webkit-user-select:none;
    -moz-user-select:none;
    -ms-user-select:none;
    -o-user-select:none;
    user-select:none;
  }

  nav ul,nav li {
    outline:0;
    margin:0;
    padding:0;
  }
  .main-menu li:hover>a,nav.main-menu li.active>a,.dropdown-menu>li>a:hover,.dropdown-menu>li>a:focus,.dropdown-menu>.active>a,.dropdown-menu>.active>a:hover,.dropdown-menu>.active>a:focus,.no-touch .dashboard-page nav.dashboard-menu ul li:hover a,.dashboard-page nav.dashboard-menu ul li.active a {
    color:#fff;
    background-color:#5fa2db;
  }
  .area {
    float: left;
    background: #e2e2e2;
    width: 100%;
    height: 100%;
  }
  @font-face {
    font-family: 'Titillium Web';
    font-style: normal;
    font-weight: 300;

  }




</style>

<style lang="PostCSS">
  @use postcss-cssnext;

  .sticky {
    position: sticky;
    will-change: transform;
  }

  .sticky--top {
    top: 0;
  }

  /*.header {*/
    /*border-radius: 20px;*/
    /*background-color: #b00cff;*/
    /*padding-bottom: 1em;*/
    /*padding-top: 1em;*/
  /*}*/

  /*.header::after {*/
    /*bottom: 0;*/
    /*box-shadow: 0 0.0625em 0.5em rgba(0, 0, 0, 0.3);*/
    /*content: '';*/
    /*left: 0;*/
    /*opacity: 0;*/
    /*position: absolute;*/
    /*right: 0;*/
    /*top: 0;*/
    /*transition: opacity 0.3s;*/
    /*z-index: -1;*/
  /*}*/



</style>


