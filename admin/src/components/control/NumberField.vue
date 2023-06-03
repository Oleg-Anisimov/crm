<template>
  <p v-if="label" class="label">{{ label }}</p>
  <input v-model="value" :class="['text', `text_${actualColor}`]" type="number" min="0" :placeholder="placeholder" @blur="validateAndSend">

</template>

<script>
export default {
  name: "NumberField",
  emits: ['valueChanged'],
  data() {
    return {
      value: null,
      actualColor: ''
    }
  },
  props: {
    label: {
      type: String,
      required: false
    },
    placeholder: {
      type: String,
      required: false,
      default: 'Введите значение'
    },
    color: {
      type: String,
      required: false,
      default: 'default'
    }
  },
  methods: {
    validateAndSend() {
      if (this.value === null || this.value <= 0) {
        this.actualColor = 'error'
      } else {
        this.actualColor = ''
      }
      this.$emit('valueChanged', value)
    }
  }
}
</script>

<style lang="scss" scoped>

p {
  margin-bottom: 0.5em;
  font-size: 1.2em;
  font-weight: 500;
}

.text {
  padding: 1em 2em;
  border: 1px solid var(--grey-3);
  border-radius: 5px;
  font-size: 1em;
  color: var(--grey-1);
  width: 100%;

  &_success {
    border: 1px solid var(--success);
  }

  &_warning {
    border: 1px solid var(--warning);
  }
  &_error {
    border: 1px solid var(--error);

  }
}
</style>