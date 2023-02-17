<template>
  <header>
    <div>
      <div class="menu_button">
        <img  src="icon_menu.svg"/>
      </div>
      <div class="company_logo">
        <img src="vite.svg" alt="">
        <h1>Vite corp</h1>
      </div>
    </div>
    <div class="userbar">
      <p>Иванов И.И.</p>
      <div class="userbar_img">
        <img  src="avatar_mock.jpg" alt="">

      </div>
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
  display: flex;
  justify-content: space-between;
  height: 7vh;
  box-shadow: 0px -5px 10px 0px rgba(0, 0, 0, 0.5);
  align-items: center;
}

.userbar {
  display: flex;
  margin-right: 2em;
}

.userbar_img > img {
  width: 50px;
  height: 50px;
  border-radius: 20%;
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

div {
  display: inline-block;
}

.menu_button {
  width: 80px;
  margin-left: auto;
  margin-right: auto;
}

.menu_button > img {
  margin: 0 auto;
}

</style>