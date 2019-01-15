<template>
  <div>

       <input  type="text" v-on="" placeholder="Username" class="input" v-model="user.username" />
       <input readonly type="submit" value="Log in" class="input input--submit" @click.prevent="getUser"/>

<!--TODO реактивное обновление данных-->
    <table>
    <thead>
    <tr>
      <th colspan="4">Bkob admin panel( double click)</th>
    </tr>
    <tr>
      <th colspan="1">Id</th>
      <th colspan="1">Username</th>
      <th colspan="1">Email</th>
      <th colspan="1" style="text-align: center" >To Do</th>


    </tr>
    </thead>
    <tbody>
    <tr>
      <td>{{response.id}}</td>
      <td>{{response.userName}}</td>
      <td>{{response.email}}</td>
      <td>
        <i  @click.sync="unban()" :class="response.state==='ACTIVE'? 'green':'red'   " class="material-icons button delete">mood</i>
        <i @click.sync="ban()" :class="response.state==='BANNED'? 'red' : 'green' " class="material-icons button delete">mood_bad</i>
        <i class="material-icons button edit ">edit</i>
        <i @click="deleteUser()" class="material-icons button delete" >delete</i>
      </td>
    </tr>
    </tbody>
  </table>
    <div v-show="error" class="text text--small text--centered">Reload and try gain</div>

    <div class="fullscreen-bg"></div>
  </div>
</template>

<script>
    import {AXIOS} from "./http-common";

    export default {
      name: "admin",


      data() {
        return {
          showSearch:null,
          response: {},
          error:  false,
          user: {
            id:null,
            username:'',
            email: '',
            state:'',

          },
        }
      },

      // mounted(){
      //
      //     // AXIOS.get(`/admin/user/allusers`)
      //     //   .then(response => {
      //     //     // JSON responses are automatically parsed.
      //     //     this.response = response.data;
      //     //     //   this.user.id = response.data;
      //     //     console.log(response.status);
      //     //     // this.showResponse = true
      //     //   })
      //     //   .catch(e => {
      //     //     this.error = true;
      //     //   })
      //
      // },

      methods:{
        getUser(){
          AXIOS.get(`/admin/user/byusername/` + this.user.username)
            .then(response => {
              // JSON responses are automatically parsed.
              this.response = response.data;
              //   this.user.id = response.data;
              console.log(response.status);
              // this.user.username=response.userName;
              // this.showResponse = true
            })
            .catch(e => {
              this.error = true;
              console.log("error in get");
            })
        },

        deleteUser(){
          console.log(this.user.id);
          AXIOS.get(`/admin/user/delete/` + this.response.id )
            .then(response => {
              // JSON responses are automatically parsed.


              //   this.user.id = response.data;
              console.log(response.status);
              // this.showResponse = true
            })
            .catch(e => {
              this.error = true;
            });
          this.getUser();
        },
        unban(){


          AXIOS.get(`/admin/user/unban/`+this.response.id)
            .then(response => {
              // JSON responses are automatically parsed.

              //   this.user.id = response.data;
              console.log(response.status);
              // this.showResponse = true

            })
            .catch(e => {
              this.error = true;
            });
          this.getUser();
        },
        ban() {

          AXIOS.get(`/admin/user/ban/`+this.response.id)
            .then(response => {
              // JSON responses are automatically parsed.
               //   this.user.id = response.data;
              console.log(response.status);
              // this.showResponse = true
              //
              //
              })
            .catch(e => {
              this.error = true;
            });

          this.getUser();
        },
      }
    }
</script>

<style scoped>
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  body {
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
    color: #333;
  }

  table {
    text-align: left;
    line-height: 40px;
    border-collapse: separate;
    border-spacing: 0;
    border: 2px solid #FF7779;
    width: 500px;
    margin: 50px auto;
    border-radius: .25rem;
  }

  thead tr:first-child {
    background: #FF7779;
    color: #fff;
    width: 800px;
    border: none;
  }

  .input {
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    font-size: 1.125rem;
    line-height: 3rem;
    width: 100%;
    height: 3rem;
    color: #444;
    background-color: rgba(255, 255, 255, .9);
    border: 111px;
    border-top: 1px solid rgba(255, 255, 255, 0.7);
    padding: 0 1rem;
    font-family: 'Open Sans', sans-serif;
  }

  .input:focus {
    outline: none;
  }

  .input--top {
    border-radius: 0.5rem 0.5rem 0 0;
    border-top: 0;
  }

  .input--submit {
    background-color: rgba(92, 168, 214, 0.9);
    color: #fff;
    font-weight: bold;
    cursor: pointer;
    border-top: 0;
    border-radius: 0 0 0.5rem 0.5rem;
    margin-bottom: 1rem;
  }


  th:first-child,
  td:first-child {
    padding: 0 15px 0 20px;
  }

  th {
    font-weight: 800;

  }
  .text {
    color: #FF787A;
    text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
    text-decoration: none;
  }
  .red{
    background-color: red;
  }


  .green{
    background-color: green;
  }


  .text--small {
    opacity: 0.85;
    font-size: 0.75rem;
    cursor: pointer;
  }

  .text--small:hover {
    opacity: 1;
  }


  .text--centered {
    /*display: block;*/
    text-align: center;
  }

  thead tr:last-child th {
    border-bottom: 3px solid #FF7779;
    background-color: #5AA4E1;

  }

  tr {
    border-bottom: 3px solid #FF7779;
    background-color: #21B49A;

  }

  tbody tr:hover {
    background-color: #BCDCF5;
    cursor: default;
  }

  /*tbody tr:last-child td {*/
    /*border: none;*/
    /*background-color: #21B49A;*/
  /*}*/

  tbody td {
    border-bottom: 1px solid #FF7779;
  }

  td:last-child {
    text-align: right;
    padding-right: 10px;
  }

  .button {
    color: #1E3567;
    cursor: pointer;
    vertical-align: middle;
    margin-top: -4px;
  }

  .edit:hover {
    color: #0a79df;
  }

  .delete:hover {
    color: #FF7779;
  }

  .fullscreen-bg {
    position: fixed;
    z-index: -1;
    top:0; right:0; bottom:0; left:0;
    background: url(https://www.readyartwork.com/wp-content/uploads/2017/06/pace-oregon-state-web-design-graphic.jpg) center;
    background-size: cover;
  }
</style>
