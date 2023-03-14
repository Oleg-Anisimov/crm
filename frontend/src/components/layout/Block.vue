<template>
  <div class="column">
    <div class="column-header">
      <h1>{{ header }}</h1>
    </div>
    <div class="column-content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "Block",
  props: {
    header: {
      type: String,
      required: false,
      default: ''
    }
  }
}
</script>

<style scoped>
.column {
  border-radius: 1em;
  border: 1px var(--primary) solid;
  min-height: 100px;
  padding: 0 2em;
}
.column-header {
  justify-self: center;
  border-bottom: 1px var(--primary) solid;
}
</style>