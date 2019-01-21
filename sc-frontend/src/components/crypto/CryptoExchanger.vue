<template>
  <div class="content-wrapper">
    <table>
      <thead>
      <tr>
        <th v-for="key in columns">
          {{ key }}
        </th>
        <th>trade</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="entry in data">
        <td v-for="key in columns">
          {{entry[key]}}
        </td>
        <td>
          <button>BUY</button>
          <button>SELL</button>
        </td>
      </tr>
      </tbody>
    </table>
    <div class="fullscreen-bg"></div>
  </div>
</template>
<script>
  import {AXIOS} from "./../http-common";

  export default {
    data() {
      return {
        columns: ['name', 'price', 'change', 'wallet'],
        data: []
      }
    },
   mounted() {
        this.getCurrencyRow('btc-usd');
        this.getCurrencyRow('xrp-usd');
        this.getCurrencyRow('eos-usd');
      },
      methods: {
      getCurrencyRow(currency) {
        AXIOS.get('https://api.cryptonator.com/api/ticker/' + currency)
            .then(response => {
            let result = response.data.ticker;
            let change = parseFloat(result.change).toFixed(3);
            change = change > 0 ? '+' + change : change;
            this.data.push({
              name: result.base,
              price: '$' + parseFloat(result.price).toFixed(3),
              change: change + '%'
            });
          })
      }
    }
  }
</script>
<style scoped>

  body {
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-size: 14px;
  }

  th {
    background-color: #224163;
    color: #fff;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }

  td {
    background-color: #203661;
    color: #fff;
  }

  th, td {
    min-width: 120px;
    padding: 10px 20px;
  }

  .content-wrapper {
    justify-content: center;
    display: flex;
  }

  .fullscreen-bg {
    position: fixed;
    z-index: -1;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background: url(https://www.readyartwork.com/wp-content/uploads/2017/06/pace-oregon-state-web-design-graphic.jpg) center;
    background-size: cover;
  }

  button {
    background-color: #87BEFE;
    box-shadow: none;
    border: 1px solid transparent;
    font-size: 14px;
    outline: none;
    line-height: 100%;
    white-space: nowrap;
    vertical-align: middle;
    padding: 0.6rem 1rem;
    border-radius: 2px;
    transition: all 0.2s ease-in-out;
    cursor: pointer;
    min-height: 38px;
  }
</style>
