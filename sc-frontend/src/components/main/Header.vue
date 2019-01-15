<template>
  <div class="container">
    <div class="innerwrap">
      <section class="section1 clearfix">
        <div>
          <div class="row grid clearfix">
            <div class="col2 first">
              <img src="../../assets/header-icons/avatar.png" alt="">
              <h1 style="color: #DB736F; font-weight: 600">Justin Moreyl</h1>
              <p style="color: #fff"> STATUS: Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's</p>
              <span>Follow</span>
            </div>
            <!--<div class="col2 first">-->
              <!--<input :class="hasAvatar===true? null : avatar" name="avatar" type="file">-->
              <!--&lt;!&ndash;<div class="image-upload">&ndash;&gt;-->
                <!--&lt;!&ndash;<label class="file-input">&ndash;&gt;-->
                  <!--&lt;!&ndash;<img src="../../assets/header-icons/avatar.png" style="pointer-events: none"/>&ndash;&gt;-->
                <!--&lt;!&ndash;</label>&ndash;&gt;-->

                <!--&lt;!&ndash;<input id="file-input" type="file" />&ndash;&gt;-->
              <!--&lt;!&ndash;</div>&ndash;&gt;-->
              <!--<h1 style="color: #DB736F; font-weight: 600">Justin Moreyl</h1>-->
              <!--<p style="color: #fff"> STATUS: Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's</p>-->
              <!--<span>Follow</span>-->
            <!--</div>-->
            <div class="col2 last">

              <div class="grid clearfix">

                <div class="col3 first">
                  <h1>694</h1>
                  <span>Following</span>
                  <br>
                  <img src="../../assets/header-icons/folowers.png" style="width: 50px; height: 50px;" alt="">
                </div>

                <div class="col3 first">
                  <h1>694</h1>
                  <span>Junior</span>
                  <br>
                  <img src="../../assets/header-icons/status.png" style="width: 50px; height: 50px;" alt="">
                </div>

                <div class="col3 last">
                  <h1>1207</h1>
                  <span>Rating</span>
                <br>
                <img src="../../assets/header-icons/rating.png" style="width: 50px; height: 50px;" alt="">
              </div>


            </div>
          </div>

        </div>
        </div>

    </section>
  </div>
  </div>

</template>

<script>
    export default {
        name: "header",
      data(){
          return{
           hasAvatar: false,
          }
      },
    }
</script>

<style scoped>

  /*.image-upload > input {*/
    /*visibility:hidden;*/
    /*width:0px;*/
    /*height:0px;*/
  /*}*/


  * {
    margin:0px;
    padding:0px;
  }
  *, *:after, *:before { -webkit-box-sizing: border-box; -moz-box-sizing: border-box; -ms-box-sizing:border-box; -o-box-sizing:border-box; box-sizing: border-box; }

  .clearfix:before, .clearfix:after { display: table; content: ''; }
  .clearfix:after { clear: both; }


  body {
    background: #E2e2e2;
    color: #333;
    font-weight: normal;
    font-size: 1em;
    font-family: 'Roboto', Arial, sans-serif;
  }

  input:focus, textarea:focus, keygen:focus, select:focus {
    outline: none;
  }
  ::-moz-placeholder {
    color: #666;
    font-weight: 300;
    opacity: 1;
  }

  ::-webkit-input-placeholder {
    color: #666;
    font-weight: 300;
  }

  .grid .col2 {
    width: 50%;
    padding: 0 10px 0 0;
  }
  .grid .col2.first {
    float: left;
  }
  .grid .col2.last {
    float: right;
  }

  .grid .col3 {
    width: 32%;
    float: left;
    margin-right: 11px;
  }
  .grid .col3.first {
    margin-left: 0;
    float: left;
  }
  .grid .col3.last {
    margin-right: 0;
    float: left;
  }

  /* profile page */
  .container {
    padding: 60px 50px 70px;
  }

  .innerwrap {
    width: 1200px;
    margin: 0 auto;
  }

  .section1 {
    background: #fff;
    position: relative;
    border-radius: 2px;
  }
  .section1 div .row:first-child {
    padding: 25px;
    background: url("../../assets/header-icons/header-bg.png") center;
    background-size: cover;
  }

  /*.avatar{*/
  /*background: url("../../assets/header-icons/avatar.png");*/
  /*}*/

  .section1 .col2.first img {
    border-radius: 50%;
    margin: 0 20px;
    width: 120px;
    border:2px solid #f1f1f1;
    padding: 2px;
    float: left;
  }
  .section1 .col2.first {
    line-height: 25px;
    position: relative;
    border-right:1px solid #FF787A;
  }
  .section1 .col2.first h1 {
    font-weight: normal;
    margin-bottom: 10px;
    margin-top: 15px;
    text-transform: capitalize;
  }
  .section1 .col2.first p {
    font-size: 14px;
  }
  .section1 .col2.first span {
    position: absolute;
    right: 15px;
    top: 16px;
    background: #6AAFEA;
    padding: 5px 11px;
    font-size: 12px;
    line-height: 1;
    border-radius: 2px;
    color: #fff;
    cursor:pointer;
  }

  .section1 .col2.last {
    padding: 8px 0;
  }
  .section1 .col2.last .col3 span {
    color: #fff;
    font-size: 14px;
  }
  .section1 .col2.last .col3 h1 {
    color: #FB4C22;
  }

  .section1 .col2.last .col3 {
    text-align: center;
    line-height: 30px;
    border-right: 1px solid #FF787A;
    font-weight: 600;
  }
  .section1 .col2.last .col3.last {
    border-right: 0;
  }

  .row2tab li {
    list-style: none;
    float: left;
    width: 25%;
    padding: 15px;
    font-size: 14px;
    text-align: center;
    cursor:pointer;
    background: #f1f1f1;
    color: #555;
    border-bottom: 2px solid #f1f1f1;
  }
  .row2tab li:first-child {
    border-bottom: 2px solid #6AAFEA;
    border-radius: 0 0 2px 2px;
  }
  .row2tab li:first-child {
    color:  #6AAFEA;
  }
  .row2tab li i {
    margin-right: 3px;
    font-size: 14px;
  }

  .smalltri i {
    position: absolute;
    top: -5px;
    right: -33px;
    color: #fff;
    border: 0px;
    font-size: 12px;
  }

  section.section2 {
    margin: 50px 0;
  }

  .section2 .col3 {
    width: 30%;
    margin-right: 60px;
    background: #fff;
    border-radius: 2px;
  }

  .section2 .postcont img {

    width: 100%;
  }
  .section2 .profileinfo {
    text-align: center;
    padding: 0 10px 30px;
    color: #555;
    font-size: 14px;
    line-height: 25px;
  }
  .section2 .profileinfo img {
    border-radius: 50%;
    width: 80px;
    padding: 2px;
    border: 3px solid #6AAFEA;
    margin-top: -48px;
    margin-bottom: 18px;
  }
  .section2 .col3.center .profileinfo img {
    border: 3px solid #FB4C22;

  }
  .section2 .profileinfo p {
    text-align: justify;
  }
  .section2 .profileinfo span {
    margin-top: 15px;
    display: block;
    text-align: left;
    color: #6AAFEA;
    cursor: pointer;
  }
  .section2 .profileinfo span i {
    margin-left: 10px;
  }

  @media only screen and (max-width: 1300px) {
    .innerwrap {
      width: 90%;
    }
    .section2 .col3 {
      margin-right: 5%;
    }
    .section1 .grid .col3 {
      margin-right: 2%;
    }
    .section1 .col2.last .col3.last {
      margin-right: 0;
    }
  }

  @media only screen and (max-width: 1060px) {
    .section1 .col2 {
      width: 100%;
      border-right:0 !important;
      padding: 0;
    }
  }

  @media only screen and (max-width: 660px) {
    .section2 .col3 {
      width: 100%;
      float: none !important;
      margin-bottom: 10px;
    }
    .row2tab li {
      width: 50%;
      text-align: left;
    }
    .section1 .col2.first {
      text-align: center;
    }
    .section1 .col2.first img {
      display: inline-block;
      float: none;
    }
    .section1 .col2.first span {
      position: relative;
      right: 0;
    }
    .section1 .col2.last {
      margin-top:25px;
    }
  }
  @media only screen and (max-width: 450px) {
    .container {
      padding: 60px 5px 70px;
    }
    .row2tab li {
      width: 100%;
      text-align: left;
    }
    .section1 .col2.last .col3 span {
      font-size: 10px;
    }
    .section1 .col2.last .col3 h1 {
      font-size: 18px;
    }

  }


</style>
