
export default class User {
    constructor(id, firstName, secondName, middleName, phone, email, roleId) {
        this.id = id
        this.firstName = firstName
        this.secondName = secondName
        this.middleName = middleName
        this.phone = phone
        this.email = email
        this.roleId = roleId
    }

    getShortName() {
        return `${this.secondName} ${this.firstName[0]}. ${this.middleName[0]}.`
    }
}