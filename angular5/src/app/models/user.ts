/**
 * Created by hexad3cimal on 5/3/18.
 */
export interface User{
  userId: string;
  userCode: string;
  emailAddress: string;
  password: string;
  isactive: boolean;
  createdDate: Date;
  lastUpdatedDate: Date;
  userRoleses : Array<any>;
  userDetailses : Array<any>;
}
