<template>
  <div class="sidebar_item">
    <img :src="image">
    <p>{{content}}</p>
  </div>
</template>

<script>
export default {
  name: "SidebarItem",
  props: ['image', 'content'],

}
</script>

<style scoped>
.sidebar_item {
  margin-top: 1em;
  text-align: center;
  color: white;

}

.sidebar_item > p {
  margin-top: 0;
}

.sidebar_item > img {
  width: 35px;
  height: 35px;
}
</style>