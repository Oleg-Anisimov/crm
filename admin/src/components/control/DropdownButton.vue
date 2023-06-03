<template>
  {{this.buttonLabel}}
  <Button  size="small" :label="this.label" @click="onButtonClick"/>
  <div v-if="!hidden" class="btn_popup">
    <ul>
      <li v-for="item in items" @click="e => emitEvent(e, item)"> {{ item.name }} </li>
    </ul>
  </div>
</template>

<script>
import Button from "./Button.vue";

export default {
  name: "DropdownButton",
  components: {Button},
  props: ['label', 'items'],
  emits: ['status-chosen'],
  data() {
    console.log(this.label)

    return {
      buttonLabel: this.label,
      hidden: true,
    }
  },
  methods: {
    onButtonClick() {this.hidden = !this.hidden},
    emitEvent(e, item) {
      this.hidden = true;
      this.$emit('status-chosen', item)
    }
  }

}
</script>

<style lang="scss" scoped>

.btn_popup {
  margin-top: 0.1em;
  border-radius: 5px;
  background-color: #fafafa;
  border: 1px solid #536b81;

  position: absolute;
  z-index: 500;
}

ul {
  margin: 0;
  list-style-type: none;
  padding: 0;
}
li {
  cursor: default;
  padding: 0.7em 1em;
}
li:hover {
  background-color: #c2c2c2;
}

</style>