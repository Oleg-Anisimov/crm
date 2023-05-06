<template>
  <p v-if="label" class="label">{{ label }}</p>
  <input :class="['text', `text_${color}`]" v-if="type === 'text'" type="text" :placeholder="placeholder">
  <textarea :class="['text', `text_${color}`]" v-if="type === 'text-area'"  :placeholder="placeholder"></textarea>

</template>

<script>
export default {
  name: "TextField",
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
    type: {
      type: String,
      required: true,
      default: 'text'
    },
    color: {
      type: String,
      required: false,
      default: 'default'
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

.text::placeholder {
  color: var(--grey-2);
}

.text:focus {
  outline: none;

}

textarea {
  max-width: 766px;
  min-width: 766px;
  font-family: Inter, system-ui, Avenir, Helvetica, Arial, sans-serif;
  min-height: 10em;
}

</style>