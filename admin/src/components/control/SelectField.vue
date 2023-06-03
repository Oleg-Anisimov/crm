<template>
  <p v-if="label">{{ label }}</p>
  <input class="text" type="text" v-model="state.value" :placeholder="placeholder" @click="changeState">
  <div class="dropdown" v-if="state.active && options.length != 0">
    <ul>
      <li v-for="item in options" @click="setValue($event, item)">{{ item.text }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "SelectField",
  emits: ['itemSelected'],
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
    options: {
      type: Array,
      required: false,
      default: []
    },
    mode: {
      type: String,
      required: false,
      default: 'single'
    }
  },
  data() {
    return {
      state: {
        value: '',
        active: false
      }
    }
  },
  methods: {
    changeState() {
      this.state.active = !this.state.active
    },
    setValue(event, item) {
      this.state.value = item.text
      this.$emit('itemSelected', item)

      this.changeState()
    },

    getFilteredItems() {
      if (this.state.value !== '') {
        console.log(true)
      }
      return this.options
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
  background: url("/dropdown.svg") no-repeat right;
  background-origin: content-box;

  &::placeholder {
    color: var(--grey-2);
  }

  &:focus {
    outline: none;
  }
}

.dropdown {
  overflow: auto;
  max-height: 250px;
  border-radius: 5px;
  border: 1px solid var(--grey-3);
  margin-top: 5px;
  scrollbar-width: thin;

  &::-webkit-scrollbar {
    width: 10px;

  }

  &::-webkit-scrollbar-track {
    background-color: #fafafa;
    border-radius: 5px;
  }

  &::-webkit-scrollbar-thumb {
    background-color: var(--primary);
    border-radius: 5px;
  }
}

ul {padding: 0}

li {
  margin-top: 5px;
  list-style: none;
  padding: 1em 2em;

  &:hover {
    color: white;
    background-color: var(--primary);
  }
}


</style>