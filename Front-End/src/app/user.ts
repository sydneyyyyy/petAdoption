export interface Customer {
    id: number;
    fname: string;
    lname: string;
    username: string;
    password: string;
    information: string;
}

export interface Employee {
    id: number;
    fname: string;
    lname: string;
    username: string;
    password: string;
    sid: number;
    species: (Species)[];
}

export interface Species {
    
}