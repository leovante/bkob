<template>
<p v-show="!responseOk">Errorr</p>
</template>

<script>
    import {AXIOS} from "./http-common";

    export default {
        name: "authorization",
        data(){
          return{
           responseOk:null,
          }
        },
      created(){
          console.log(this.$route.params.code);
          AXIOS.post('public/activate/' + this.$route.params.code)
            .then(response => {
              // JSON responses are automatically parsed.
              this.responseOk=true;
              //   this.user.id = response.data;
              console.log(response.status);
              // this.showResponse = true
            })
            .catch(e => {
              this.responseOk = false;
            });
      }
    }
</script>

<style scoped>

</style>
