/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.runner.game.element.level;

import org.andengine.entity.IEntity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.adt.color.Color;
import org.game.runner.game.player.Player;

/**
 *
 * @author Karl
 */
public class BonusSlow extends LevelElement{
    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    @Override
    public IEntity createEntity(float pX, float pY, VertexBufferObjectManager pVertexBufferObjectManager, final Player player, final PhysicsWorld physicsWorld) {
        IEntity entity = new Rectangle(pX, pY, BONUS_WIDTH, BONUS_HEIGHT, pVertexBufferObjectManager){
            @Override
            protected void onManagedUpdate(float pSecondsElapsed){
                super.onManagedUpdate(pSecondsElapsed);
                if(player.collidesWith(this)){
                    player.hit(this);
                    player.resetBonus();
                    player.setColor(this.getColor());
                    player.setSpeed(0.7f);
                }
            }
        };
        entity.setColor(this.getColor());
        return entity;
    }
}
