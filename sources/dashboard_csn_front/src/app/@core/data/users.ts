import { Observable } from 'rxjs';
/**
 * @author K.ELBAGUARI && O.SLAAOUITER
 */
export interface User {
  name: string;
  picture: string;
}


export abstract class UserData {
  abstract getUsers(): Observable<User[]>;
}
