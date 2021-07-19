import { Component, OnInit } from '@angular/core';
import { Pet, Species, Breed } from '../pet';
import { Observable, Subject, of} from 'rxjs';
import {
  debounceTime, distinctUntilChanged, switchMap
} from 'rxjs/operators';
import { catchError, map, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from '../message.service';


@Component({
  selector: 'app-pet-search',
  templateUrl: './pet-search.component.html',
  styleUrls: ['./pet-search.component.css']
})


export class PetSearchComponent implements OnInit {

  species: any;
  pets: Observable<Pet[]>;
  private apiServerUrl = environment.apiBaseUrl;
  private searchTerms = new Subject<string>();

  constructor(private http: HttpClient, private messageService: MessageService) { }

  search(term: string): void {
  this.searchTerms.next(term);
  }

  private log(message: string) {
    this.messageService.add(`HeroService: ${message}`);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


  searchPets(term: string): Observable<Pet[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this.http.get<Pet[]>(`${this.apiServerUrl}/?name=${term}`).pipe(
      tap(x => x.length ?
        this.log(`found heroes matching "${term}"`) :
        this.log(`no heroes matching "${term}"`)),
      catchError(this.handleError<Pet[]>('searchHeroes', []))
    );
  }

  ngOnInit(): void {

    this.pets = this.searchTerms.pipe(
            // wait 300ms after each keystroke before considering the term
            debounceTime(300),
      
            // ignore new term if same as previous term
            distinctUntilChanged(),
      
            // switch to new search observable each time the term changes
            switchMap((term: string) => this.searchPets(term)),
          );
        }
  

        

}




// import { Component, OnInit } from '@angular/core';

// import { Observable, Subject } from 'rxjs';

// import {
//    debounceTime, distinctUntilChanged, switchMap
//  } from 'rxjs/operators';

// import { Hero } from '../hero';
// import { HeroService } from '../hero.service';

// @Component({
//   selector: 'app-hero-search',
//   templateUrl: './hero-search.component.html',
//   styleUrls: ['./hero-search.component.css']
// })
// export class HeroSearchComponent implements OnInit {

//   heroes$!: Observable<Hero[]>;
//   private searchTerms = new Subject<string>();


//   constructor(private heroService: HeroService) {}

//   search(term: string): void {
//     this.searchTerms.next(term);
//   }
  
//   ngOnInit(): void {
//     this.heroes$ = this.searchTerms.pipe(
//       // wait 300ms after each keystroke before considering the term
//       debounceTime(300),

//       // ignore new term if same as previous term
//       distinctUntilChanged(),

//       // switch to new search observable each time the term changes
//       switchMap((term: string) => this.heroService.searchHeroes(term)),
//     );
//   }
// }