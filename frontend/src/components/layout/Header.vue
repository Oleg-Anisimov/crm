<template>
  <header>
    <div>
      <div class="company_logo">
        <img src="vite.svg" alt="">
        <h1>Vite corp</h1>
      </div>
    </div>

    <div class="searchbar">
      <input type="text" placeholder="Search">
    </div>
    <div class="userbar">
      <p>Иванов И.И.</p>
      <img src="avatar_mock.jpg" alt="">
    </div>
  </header>

</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: 'Header'
})
</script>

<style scoped>
header {
  /*background-color: #f1f1f1;*/
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
}

.userbar {
  justify-self: end;
}

.userbar > img {
  width: 50px;
  height: 50px;
  border-radius: 20%;
}

.searchbar > input {
  width: 98.5%;
  height: 1.7em;
}

.company_logo {
  margin-left: 2em;
  min-width: 240px
}
.userbar_img {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  margin-left: 10px;
}

h1 {
  margin: 0;
  margin-left: 0.5em;
  display: inline-block;
}

p {
  display: inline-block;
}

</style>