<template>
<div>
  <div class="container unauthenticated">
    With Google <a href="http://localhost:8080"> <button class="btn btn-primary">Log in Google</button></a>
  </div>
  <div class="container authenticated" style="display:none">
    Logged in as: <span id="user"></span>
  </div>

  <div class="container authenticated">
    Logged in as: <span id="user2"></span>
    <div>
      <button onClick="logoutUser()" class="btn btn-primary">Logout</button>
    </div>
  </div>
</div>
</template>

<script>
  // import axios from 'axios'
  import {AXIOS} from './http-common'

  export default {
    name: 'login',

    data () {
      return {
        response: [],
        errors: [],
        user: {
          email: '',
          password: ''

        },
        showResponse: false,
        retrievedUser: {},
        showRetrievedUser: false
      }
    },
    methods: {
      // Fetches posts when the component is created.
      loginUser () {
          AXIOS.get(`/oauth`, params)
            .then(response => {
              // JSON responses are automatically parsed.
              this.response = response.data;
              //   this.user.id = response.data;
              console.log(response.data);
              this.showResponse = true
            })
            .catch(e => {
              this.errors.push(e)
            })
      },
      logoutUser () {
        AXIOS.post(`/oauth`, params)
          .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data;
            //   this.user.id = response.data;
            console.log(response.data);
            this.showResponse = true
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      // retrieveUser () {
      //   AXIOS.get(`/login` + this.user.id)
      //     .then(response => {
      //       // JSON responses are automatically parsed.
      //       this.retrievedUser = response.data;
      //       console.log(response.data);
      //       this.showRetrievedUser = true
      //     })
      //     .catch(e => {
      //       this.errors.push(e)
      //     })
      // }
    }
  }

</script>



<style>
  .container {
    margin-top:4em;
    margin-bottom:4em;
  }




</style>
