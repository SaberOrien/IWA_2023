import { Component } from '@angular/core';
import {Article} from "./article/article.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  articles: Article[];

  constructor() {
    this.articles=[
      new Article('The Nice and Accurate Prophecies of Agnes Nutter, Witch', 'https://www.goodreads.com/book/show/12067.Good_Omens?from_search=true&from_srp=true&qid=quGjeyMICb&rank=1', 7),
      new Article('Taming Demons for Beginners', 'https://www.goodreads.com/book/show/44932446-taming-demons-for-beginners?ref=nav_sb_ss_1_18', 8),
      new Article('Six of Crows', 'https://www.goodreads.com/book/show/23437156-six-of-crows?ref=nav_sb_ss_1_12', 10),
    ]
  }
  addArticle(title: HTMLInputElement, link: HTMLInputElement): boolean{
    console.log(`Adding article title: ${title.value} and link: ${link.value}`);
    this.articles.push(new Article(title.value, link.value, 0));
    title.value='';
    link.value='';
    return false;
  }

  sortedArticles(): Article[] {
    return this.articles.sort((a: Article, b: Article) => b.votes - a.votes);
  }
}
