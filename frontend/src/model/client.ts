import ContactPerson from "./contact_person";

export default interface Client {
    id: number,
    clientType: string,
    contactPerson: ContactPerson

}