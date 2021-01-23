import { Component, OnInit } from '@angular/core';
import {User} from "../model/user";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  public user: User;

  constructor(private route: ActivatedRoute, private userService: UserService ) { }

  ngOnInit(): void {

    let userId = this.route.snapshot.params['id'];
    this.userService.getUser(userId).subscribe(data => this.user = data);

  }

}
