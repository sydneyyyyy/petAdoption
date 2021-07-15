export interface Pet {
    id: number;
    name: string;
    breed: (Breed)[];
}

export interface Breed {
    id: number;
    breed: string;
}