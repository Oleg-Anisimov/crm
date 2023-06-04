<template>
  <div class="tab-view">
    <div class="tab-nav">
      <span v-for="tab in tabs" :key="tab.name" :class="['tab-nav__item', {'selected': tab.name === selectedTab}]" @click="this.$emit('tabSelected', tab.name)">
        {{ tab.label }}
      </span>
    </div>
    <div class="tab-content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "TabLayout",
  emits: ['tabSelected'],
  props: {
    tabs: {
      type: Array,
      required: true
    },
    selectedTab: {
      type: String,
      required: false
    }
  }
}
</script>

<style lang="scss" scoped>

.tab-nav {
  padding-left: 1em;
  margin-bottom: 1em;

}

.tab-nav__item {
  font-size: 18px;
  margin-right: 2em;
  cursor: default;
  border-bottom: #bbbbbb 2px solid;

  &:hover {
    border-bottom: #536b81 3px solid;
  }
  &.selected {
    border-bottom: var(--primary) 3px solid;
  }
}

.tab-nav__item:hover {

}

</style>