/**
 * Created by hexad3cimal on 5/3/18.
 */

export interface UserDetails{

  detailsId: string;
  firstname: string;
  lastname: string;
  grade: string;
  subjectId: string;
  telephoneHome: string;
  telephoneLand: string;
  telephoneWork: string;
  parentName: string;
  studentState: string;
  carriculum: string;
  skypeId: string;
  gtalkId: string;
  logoImage: string;
  description: string;
  gender: string;
  email2: string;
  addressPresent: string;
  addressPermanent: string;
  panNumber: string;
  dob: Date;
  country: {countryId : string};
}
