import { Pet, Breed, Species } from "./pet"
import { Customer } from "./customer"

export interface Application {
    id: number;
    subdate: string;
    bsupapproval: false;
    secondapproval: false;
    status: string;
    pet: (Pet)[];
    customer:(Customer)[];
}
