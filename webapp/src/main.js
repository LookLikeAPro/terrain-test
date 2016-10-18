import 'pixi'
import 'p2'
import Phaser from 'phaser'

import BootState from './states/Boot'
import SplashState from './states/Splash'
import GameState from './states/Game'
import {getWidth, getHeight} from './browser'

class Game extends Phaser.Game {

  constructor () {
    let width = Math.max(getWidth(), 1024);
    let height = Math.max(getHeight(), 768);

    super(width, height, Phaser.AUTO, 'content', null)

    this.state.add('Boot', BootState, false)
    this.state.add('Splash', SplashState, false)
    this.state.add('Game', GameState, false)

    this.state.start('Boot')
  }
}

const game = new Game();
window.game = game;
