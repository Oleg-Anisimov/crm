<template>
  <button :class="['btn', `btn_${color}`]">{{ label }}</button>
</template>

<script>
export default {
  name: "Button",
  props: {
    label: {
      type: String,
      required: false,
      default: 'Button'
    },
    color: {
      type: String,
      required: false,
      default: 'primary'
    }
  }
}
</script>

<style lang="scss" scoped>
.btn {
  margin-top: 1em;
  padding: 1em 5em;
  color: white;
  border-radius: 8px;
  border: none;
  font-weight: bold;
  &_primary {
    background-color: var(--primary);

    &:enabled:hover {
      background-color: var(--primary-hover);
    }
  }

  &_second {
    background-color: var(--second);

    &:enabled:hover {
      background-color: var(--second-hover);
    }
  }
}

</style>