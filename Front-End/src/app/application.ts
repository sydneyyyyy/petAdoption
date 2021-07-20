import { Pet, Breed, Species } from "./pet"
import { Customer } from "./customer"

export interface Application {
    id: number;
    subdate: string;
    bsupapproval: boolean;
    secondapproval: boolean;
    status: string;
    information: string;
    pet: (Pet)[];
    customer:(Customer)[];
}
