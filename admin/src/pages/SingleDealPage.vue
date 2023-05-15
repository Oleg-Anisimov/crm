<template>
  <div class="content">
    <h1>Deal {{ $route.params.id }}</h1>

  </div>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "SingleDealPage",
  data() {
    return {
      deal: null,
      loading: false
    }
  },
  methods: {
    ...mapActions({
      fetchData: 'deals/FETCH_SINGLE'
    })
  },

  created() {
    this.$watch(
        () => this.$route.params,
        () => {
          this.fetchData( this.$route.params.id )
        },
        { immediate: true }
    )
  },
}
</script>

<style scoped>
.content {
  border-radius: 8px;
  border: 1px solid #242424;
  padding: 1em 1em;
}

h1 {
  margin-top: 0;
}
</style>