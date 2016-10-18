/* globals __DEV__ */
import {State} from 'phaser'
import Mushroom from '../sprites/Mushroom'
import Terrain from '../sprites/Terrain'
import {setResponsiveWidth} from '../utils'
import atmosphere from "atmosphere.js"

export default class extends State {
  init () {
    this.cursors = this.game.input.keyboard.createCursorKeys();
    var request = {url: "http://localhost:8080/game",
        transport: 'websocket',
        enableProtocol: true,
        trackMessageLength: true,
        logLevel: 'debug'};
    request.onOpen = function (response) {
        // Socket open.. start the game loop.
        Console.log('Info: ' + ' connection opened.');
        Console.log('Info: Press an arrow key to begin.');
    };
    atmosphere.subscribe(request)
  }
  preload () {}

  create () {
    let banner = this.add.text(this.game.world.centerX, this.game.height - 30, 'Phaser + ES6 + Webpack')
    banner.font = 'Nunito'
    banner.fontSize = 40
    banner.fill = '#77BFA3'
    banner.anchor.setTo(0.5)

    this.mushroom = new Mushroom({
      game: this.game,
      x: this.game.world.centerX,
      y: this.game.world.centerY,
      asset: 'mushroom'
    })

    // set the sprite width to 30% of the game width
    setResponsiveWidth(this.mushroom, 30, this.game.world)
    this.game.add.existing(this.mushroom)

    var map = {
      0: {
        0: [[0,0], [0, 0]]
      }
    }

    this.tile = new Terrain({
      game: this.game,
      x: 0,
      y: 0,
      asset: 'tile-sand'
    })

    // set the sprite width to 30% of the game width
    setResponsiveWidth(this.tile, 2, this.game.world)
    this.game.add.existing(this.tile)
  }

  update() {

    if (this.cursors.left.isDown)
    {
        this.game.camera.x -= 4;
    }
    else if (this.cursors.right.isDown)
    {
        this.game.camera.x += 4;
    }

    if (this.cursors.up.isDown)
    {
        this.game.camera.y -= 4;
    }
    else if (this.cursors.down.isDown)
    {
        this.game.camera.y += 4;
    }
  }

  render () {
    if (__DEV__) {
      this.game.debug.spriteInfo(this.mushroom, 32, 32)
      this.game.debug.cameraInfo(this.game.camera, 32, 128);
    }
  }
}
