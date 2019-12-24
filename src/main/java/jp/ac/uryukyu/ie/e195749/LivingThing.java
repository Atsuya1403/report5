package jp.ac.uryukyu.ie.e195749;

/**
 *LivingThingクラス
 *
 * String name = 敵の名前
 * int hitpoint = 敵の体力
 * int attack = 敵の攻撃力
 * boolean dead = 死亡判定
 *
 * @author e195749
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * LivingThingのコンストラクタ
     *
     * @param name = 名前
     * @param maximumHP = 最大体力
     * @param attack = 攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public boolean isDead(){
        return dead;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHitPoint(){
        return hitPoint;
    }

    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    public int getAttack(){
        return attack;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    /**
     * 相手に攻撃をするためのメソッド
     * 与えるダメージを乱数で指定する
     *
     *
     * @param opponent = 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(isDead() != true){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            wounded(damage);
        }
    }

    /**
     * HPが0の場合死亡判定とする
     *
     * @param damage = ダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
