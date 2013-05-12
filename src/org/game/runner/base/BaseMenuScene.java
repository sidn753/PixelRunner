/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.runner.base;

import org.andengine.entity.scene.background.AutoParallaxBackground;
import org.andengine.entity.scene.background.ParallaxBackground;
import org.andengine.entity.sprite.Sprite;

/**
 *
 * @author Karl
 */
public abstract class BaseMenuScene extends BaseScene{
    private AutoParallaxBackground autoParallaxBackground;
    private Sprite parallaxLayer1;
    private Sprite parallaxLayer2;
    private Sprite parallaxLayer3;
    private Sprite parallaxLayer4;
    
    @Override
    public void createScene() {
        this.createBackground();
    }
    
    private void createBackground(){
        this.autoParallaxBackground = new AutoParallaxBackground(0, 0, 0, 5);
        this.setBackground(autoParallaxBackground);
        this.parallaxLayer1 = new Sprite(0, 0, this.resourcesManager.mainMenuParallaxLayer1, this.vbom);
        this.parallaxLayer2 = new Sprite(0, 0, this.resourcesManager.mainMenuParallaxLayer2, this.vbom);
        this.parallaxLayer3 = new Sprite(0, 0, this.resourcesManager.mainMenuParallaxLayer3, this.vbom);
        this.parallaxLayer4 = new Sprite(0, 0, this.resourcesManager.mainMenuParallaxLayer4, this.vbom);
        this.parallaxLayer1.setOffsetCenter(0, 0);
        this.parallaxLayer2.setOffsetCenter(0, 0);
        this.parallaxLayer3.setOffsetCenter(0, 0);
        this.parallaxLayer4.setOffsetCenter(0, 0);
        this.autoParallaxBackground.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-10.0f, this.parallaxLayer1));
        this.autoParallaxBackground.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-15.0f, this.parallaxLayer2));
        this.autoParallaxBackground.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-20.0f, this.parallaxLayer3));
        this.autoParallaxBackground.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-25.0f, this.parallaxLayer4));
    }

    @Override
    public void onPause() {
        this.audioManager.pause();
    }

    @Override
    public void onResume() {
        this.audioManager.resume();
    }
    
    @Override
    public void disposeScene() {
        this.parallaxLayer1.detachSelf();
        this.parallaxLayer1.dispose();
        this.parallaxLayer2.detachSelf();
        this.parallaxLayer2.dispose();
        this.parallaxLayer3.detachSelf();
        this.parallaxLayer3.dispose();
        this.parallaxLayer4.detachSelf();
        this.parallaxLayer4.dispose();
    }
}
