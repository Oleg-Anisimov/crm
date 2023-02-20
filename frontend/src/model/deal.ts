import Person from "./person";

export default interface Deal {
    id: number,
    title: string,
    amount: number,
    status: string,
    responsiblePeoples: Array<Person>
}