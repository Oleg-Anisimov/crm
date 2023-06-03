<template>
  <div>
    <p @mouseover="showDetails" @mouseleave="hideDetails" class="client_name">{{ organizationName ? organizationName : person.shortName }}</p>
    <div v-if="!hidden" class="details" @mouseover="showDetails" @mouseleave="hideDetails">
          <p class="contact">Контактное лицо:</p>
          <p class="contact">{{ person.fullName }}</p>
          <p class="contact">Phone:</p>
          <p class="contact">{{ person.phone }}</p>
          <p class="contact">Email:</p>
          <p class="contact"><a :href="'mailto:' + person.email">{{ person.email }}</a> </p>
    </div>
  </div>

</template>

<script>
export default {
  name: "ClientPreview",
  props: ['organizationName', 'person', 'clientType'],
  data() {
    return {
      timeoutId: 0,
      hidden: true
    }
  },
  methods: {
    showDetails() {
      this.hidden = false
      clearTimeout(this.timeoutId)
      this.timeoutId = 0;
    },
    hideDetails() {
      this.timeoutId = setTimeout((a) => {
        this.hidden = true
      }, 0)

    }
  },
}
</script>

<style scoped>
.details {
  padding: 1em;
  border-radius: 10px;
  border: 1px solid var(--primary);
  background-color: #fafafa;
  position: absolute;
  z-index: 499;
}

p.contact:nth-child(odd) {
  color: #536b81;
  font-size: 12px;
  margin: 0;
}

p.contact:nth-child(even) {
  margin-top: 0;
  margin-bottom: 0.5em;
}

p.client_name {
  margin: 0;
}
</style>