<template>
  <section class="wrapper">

    <img class="logo framed" style="height: 70px" v-if="" src="./../assets/bkob-logo.png" alt="Bkob logo"/> EXCHANGER
    <!-- Row title -->
    <main class="row title">
      <ul>
        <li>NAME </li>
        <li>PRICE</li>
        <li>CHANGE</li>
        <li>WALLET</li>
        <li>TRADE</li>
      </ul>
    </main>
    <!-- Row 1 - fadeIn -->
    <section class="row-fadeIn-wrapper">
      <article class="row fadeIn nfl">
        <ul>
          <li><a href="#">BTC</a><span class="small">(fadeIn)</span></li>
          <li>$9000</li>
          <li>+3%</li>
          <li>0.015</li>
          <li><button id="button">BUY</button> <button id="button">SELL</button></li>
        </ul>
      </article>
    </section>
    <!-- Row 2 - fadeOut -->
    <section class="row-fadeOut-wrapper">
      <article class="row nfl">
        <ul>
          <li><a href="#">LTC</a><span class="small">(fadeIn)</span></li>
          <li></li>
          <li></li>
          <li></li>
          <li><button id="button">BUY</button> <button id="button">SELL</button></li>
        </ul>
      </article>
    </section>
    <!-- Row 3 -->
    <article class="row nfl">
      <ul>
        <li><a href="#">XRP</a></li>
        <li></li>
        <li></li>
        <li></li>
        <li><button id="button">BUY</button> <button id="button">SELL</button></li>
      </ul>

    </article>
    <!-- Row 4 -->
    <article class="row mlb update-row">
      <ul>
        <li><a href="#">BCC</a><span class="small">(update)</span></li>
        <li></li>
        <li></li>
        <li></li>
        <li><button id="button">BUY</button> <button id="button">SELL</button></li>
      </ul>

    </article>
    <!-- Row 5 -->
    <article class="row mlb">
      <ul>
        <li><a href="#">EOS</a></li>
        <li></li>
        <li></li>
        <li></li>
        <li><button id="button">BUY</button> <button id="button">SELL</button></li>
      </ul>

    </article>
    <!-- Row 6 -->
    <article class="row nhl">
      <ul>
        <li><a href="#">XLM</a></li>
        <li></li>
        <li></li>
        <li></li>
        <li><button id="button">BUY</button> <button id="button">SELL</button></li>
      </ul>

    </article>
    <!-- Row 7 -->
    <article class="row nhl">
      <ul>
        <li><a href="#">ADA</a></li>
        <li></li>
        <li></li>
        <li></li>
        <li><button id="button">BUY</button> <button id="button">SELL</button></li>
      </ul>

    </article>
    <!-- Row 8 -->
    <article class="row pga">
      <ul>
        <li><a href="#">TRX</a></li>
        <li></li>
        <li></li>
        <li></li>
        <li><button id="button">BUY</button> <button id="button">SELL</button></li>
      </ul>

    </article>
    <!-- Row 9 -->
    <article class="row pga">
      <ul>
        <li><a href="#">NEO</a></li>
        <li></li>
        <li></li>
        <li></li>
        <li><button id="button">BUY</button> <button id="button">SELL</button></li>
      </ul>

    </article>
    <!-- Row 10 -->
    <article class="row pga">
      <ul>
        <li><a href="#">EUR</a></li>
        <li></li>
        <li></li>
        <li></li>
        <li><button id="button">BUY</button> <button id="button">SELL</button></li>
      </ul>

    </article>
    <!-- Row 11 -->
    <article class="row mlb">
      <ul>
        <li><a href="#">USD</a></li>
        <li></li>
        <li></li>
        <li></li>
        <li><button id="button">BUY</button> <button id="button">SELL</button></li>
      </ul>

    </article>
  </section>
</template>

<script>
    export default {
        name: "Exchanger"

    }
</script>

<style lang="scss">

  /* Google fonts - Open Sans */
  @import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);

  /* colors */
  $blue:rgba(79,192,210,1);
  $green:rgba(82,210,154,1);
  $yellow:rgba(231,196,104,0.7);
  $orange:rgba(235,118,85,1);
  $dark-bg: rgb(0, 26, 92);
  $light-bg: rgba(0, 150, 136, 0.1);
  $text:rgba(255,255,255,0.9);

  /* body */
  body {
    background:$dark-bg;
    font-family: 'Open Sans', sans-serif;
  }

  /* links */
  .nfl a, .mlb a, .nhl a, .pga a {text-decoration:none;transition: color 0.2s ease-out;}
  .nfl a {color:$blue;}
  .nfl a:hover {color:darken($blue, 20%);}
  .mlb a {color:$green;}
  .mlb a:hover {color:darken($green, 20%);}
  .nhl a {color:$yellow;}
  .nhl a:hover {color:darken($yellow, 20%);}
  .pga a {color:$orange;}
  .pga a:hover {color:darken($orange, 20%);}

  /* wrapper */
  .wrapper {
    width:100%;
    max-width:1000px;
    margin:20px auto 100px auto;
    padding:0;
    background:$light-bg;
    color:$text;
    overflow:hidden;
    position:relative;
  }

  /* lists */
  .row ul {
    margin:0;
    padding:0;
  }
  .row ul li  {
    margin:0;
    font-size:16px;
    font-weight:normal;
    list-style:none;
    display:inline-block;
    width:20%;
    box-sizing:border-box;
    @media only screen and (max-width:767px) and (min-width:480px) {
      font-size:13px;
    }
    @media only screen and (max-width:479px) {
      font-size:13px;
    }
  }

  .title ul li {
    padding:15px 13px;
  }
  .row ul li {
    padding:5px 10px;
  }

  /* rows */
  .row {
    padding:20px 0;
    height:30px;
    font-size:0;
    position:relative;
    overflow:hidden;
    transition:all 0.2s ease-out;
    border-top:1px solid darken($light-bg, 100%);
  }
  .row:hover {
    background-color:lighten($dark-bg, 10%);
    height:65px;
    @media only screen and (max-width : 767px) {
      height:85px;
    }
    @media only screen and (max-width : 359px) {
      height:105px;
    }
  }
  .title {
    padding:25px 0 5px 0;
    height:45px;
    font-size:0;
    background-color:$light-bg;
    border-left:3px solid lighten($light-bg, 100%);
  }
  .title:hover {
    height:45px;
    background-color:$light-bg;
    border-left:3px solid lighten($light-bg, 100%);
  }

  .title-hide {
    @media only screen and (max-width:767px) {
      display:none;
    }
  }

  .nfl {border-left:3px solid darken($blue, 30%);}
  .nfl:hover {border-left:3px solid $blue;}
  .mlb {border-left:3px solid darken($green, 30%);}
  .mlb:hover {border-left:3px solid $green;}
  .nhl {border-left:3px solid darken($yellow, 30%)}
  .nhl:hover {border-left:3px solid $yellow;}
  .pga {border-left:3px solid darken($orange, 30%);}
  .pga:hover {border-left:3px solid $orange;}

  /* row one - fadeIn */
  .row-fadeIn-wrapper {
    opacity:0;
    font-size:0;
    height:0;
    overflow:hidden;
    position:relative;
    transition:all 0.2s ease-out;
    animation:fadeIn 0.4s ease-out 2s 1 alternate;
    animation-fill-mode:forwards;
  }
  .row-fadeIn-wrapper:hover {
    height:35px;
    @media only screen and (max-width : 767px) {
      height:55px;
    }
    @media only screen and (max-width : 359px) {
      height:75px;
    }
  }

  .fadeIn {
    padding:20px 0;
    font-size:0;
    position:absolute;
    transition:all 0.2s ease-out;
    width:100%;
  }
  .fadeIn:hover {
    background-color:lighten($dark-bg, 50%);
  }

  /* row two - fadeOut */
  .row-fadeOut-wrapper {
    font-size:0;
    overflow:hidden;
    position:relative;
    transition:all 0.2s ease-out;
    animation:fadeOut 0.4s ease-out 8s 1 alternate;
    animation-fill-mode:forwards;
    opacity:1;
    height:65px;
  }
  .row-fadeOut-wrapper:hover {
    height:100px;
  }

  /* update content */
  .update-row {
    animation:update 0.5s ease-out 12s 1 alternate;
  }
  .update1 {
    position:absolute;
    top:25px;
    display:inline-block;
    opacity:1;
    animation:update1 1s ease-out 12s 1 alternate;
    animation-fill-mode:forwards;
  }
  .update2 {
    position:absolute;
    top:25px;
    display:inline-block;
    opacity:0;
    animation:update2 4s ease-out 13s 1 alternate;
    animation-fill-mode:forwards;
  }

  /* more content */
  ul.more-content li {
    position:relative;
    top:22px;
    font-size:13px;
    margin:0;
    padding:10px 13px;
    display:block;
    height:50px;
    width:100%;
    color:darken($text,50%);
    @media only screen and (max-width:767px) {
      font-size:11px;
    }
  }

  /* small content */
  .small {
    color:darken($text,60%);
    font-size:10px;
    padding:0 10px;
    margin:0;
    @media only screen and (max-width:767px) {
      display:none;
    }
  }

  /* keyframe animations */
  @keyframes fadeIn {
    from {background:$light-bg;opacity:0;padding:0;}
    to {background:darken($light-bg,80%);opacity:1;padding:0 0 65px 0;}
  }
  @keyframes fadeOut {
    from {background:darken($light-bg,80%);opacity:1;height:65px;}
    to {background:$light-bg;opacity:0;height:0;}
  }
  @keyframes update {
    0% {background:darken($light-bg,80%);}
    50% {background:$light-bg;}
    100% {background:darken($light-bg,80%);}
  }
  @keyframes update1 {
    0% {opacity:0;}
    0% {opacity:1;}
    100% {opacity:0;}
  }
  @keyframes update2 {
    0% {opacity:0;color:$text;}
    20% {opacity:1;color:$green;}
    100% {opacity:1;color:$text;}
  }

  #button {
    /*Reset*/
    display: inline-block;
    outline: none;
    background-color: white;

    /*Some fancy stuff*/
    padding: 0 20px;
    line-height: 200%;
    border: 1px solid silver;

    /*Magic*/
    background-image: linear-gradient(#71bdff, #71bdff 50%, #f1464c 50%, #f1464c);
    background-size: 100% 200%;
    transition: background-position .3s;

    &:hover {
      background-position: 0 -100%;
    }


  }



</style>
