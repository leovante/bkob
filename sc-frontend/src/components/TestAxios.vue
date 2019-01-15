
<template>


  <p>Users {{users}}</p>


</template>

<script>
  import {AXIOS} from './http-common'

    export default {
      name: 'TestAxios',
        data() {
          return {
           users: []
          }
        },
      methods: {
        function() {
          var params = new URLSearchParams();

          AXIOS.get('/test', params)
            .then(response => {
              console.log(response.data);
              this.users = response.data;
              this.user.id = response.data;

            })
            .catch(error => {
              console.log(error)
            })
        }
        }
    }
</script>

<style scoped>

</style>
