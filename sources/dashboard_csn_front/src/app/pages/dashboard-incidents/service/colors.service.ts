import { Injectable } from '@angular/core';
import { RandomColor } from 'angular-randomcolor';

@Injectable({
  providedIn: 'root',
})
export class ColorsService {
  colors = new Set();
  customColor = [];
  getRandomColor(entries: any) {
    entries.forEach(() => {
      const newColor: string = RandomColor.generateColor();
      this.colors.add(newColor);
    });
    this.colors.forEach((value: string) => {
      this.customColor.push(value);
    });
    return this.customColor;
  }
}
