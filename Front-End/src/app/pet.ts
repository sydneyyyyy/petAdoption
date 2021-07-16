export interface Pet {
    id: number;
    name: string;
    age: number;
    gender: string;
    image: string;
    price: number;
    size: string;
    available: boolean;
    breed: (Breed)[];
}

export interface Breed {
    id: number;
    bname: string;
    species: (Species)[];
}

export interface Species {
    id: number;
    sname: string;
}