import {Sprite} from 'phaser'

export default class extends Sprite {

  constructor ({ game, x, y, asset }) {
    super(game, x, y, asset)

    this.game = game
    this.anchor.setTo(0)
  }

  update () {
    // this.angle += 1
  }

}
