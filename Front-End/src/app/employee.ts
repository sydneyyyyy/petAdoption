import { Species } from "./pet";
export interface Employee {
    id: number;
    fname: string;
    lname: string;
    username: string;
    password: string;
    species: Species;
}