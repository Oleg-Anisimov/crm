
<template>
  <button :class="['btn', `btn_${size}`, `btn_${color}`]">{{ label }}</button>
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
    },
    size: {
      type: String,
      required: false,
      default: 'large'
    }
  }
}
</script>

<style lang="scss" scoped>
.btn {

  color: white;
  border: none;
  font-weight: bold;
  &_large {
    border-radius: 8px;
    margin-top: 1em;
    padding: 1em 5em;
  }
  &_medium {
    border-radius: 5px;
    margin-top: 0.7em;
    padding: 0.7em 3em;
  }
  &_small {
    border-radius: 3px;
    margin-top: 0.5em;
    padding: 0.5em 1em;
  }
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

  &_red {
    background-color: var(--danger);

    &:enabled:hover {
      background-color: var(--danger-hover);
    }
  }
}

</style>