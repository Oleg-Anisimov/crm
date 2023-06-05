<template>
  <div class="auth_form">
    <p v-if="!valid">Неправильная почта или пароль</p>
    <text-field type="text" placeholder="ivan@mail.com" label="Email" :color="valid ? '' : 'error'" @value-changed="value => credentials.username = value"/>
    <text-field type="password" placeholder="Password" label="Пароль" :color="valid ? '' : 'error'" @value-changed="value => credentials.password = value"/>
    <Button label="Войти" @click="authenticate()"/>
  </div>
</template>

<script>
import TextField from "../components/control/TextField.vue";
import Button from "../components/control/Button.vue";
import {mapActions} from "vuex";
import router from "../router.js";

export default {
  name: "AuthPage",
  components: {Button, TextField},
  data() {
    return {
      credentials: {},
      valid: true,
    }
  },
  methods: {
    ...mapActions({
      login: 'users/LOGIN'
    }),
    authenticate() {
      this.login(this.credentials).then(response => {
        if (response.status === 200) {
          router.push('/deals')
        } else {
          this.valid = false
          console.log('invalid data')
        }
      })
    }
  }
}
</script>

<style scoped>

.auth_form {
  width: 400px;
  margin: 3em auto;
  padding: 1em;
  border-radius: 10px;
  border: 1px solid var(--primary);
}

p {
  text-align: center;
  color: var(--error);
}

</style>