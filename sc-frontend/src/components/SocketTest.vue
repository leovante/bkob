<template>

  <button type="submit" class="btn btn-primary" @click="redirect()">Submit</button>

</template>

<script>
    export default {
        name: "test",

      data () {
        return {
          response: [],
          errors: [],
          user: {
           firstName:''

          },
          showResponse: false,
          retrievedUser: {},
          showRetrievedUser: false
        }
      },
      methods: {
          redirect() {
            this.$router.push('TestChat')
          }

      }
    }
</script>

<style scoped>

</style>
