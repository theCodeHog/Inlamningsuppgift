package potionStoreExtras;

import com.company.View;

public class StoryText {

    String userStatus; //TODO
    String name;

    //METHODS

    //BEGINNING THE STORY
    public void startAdventure() {
        System.out.println("----------------------------EXPLORING THE POTION STORE----------------------------");
        System.out.println("You walked past this little nameless shop plenty of times, but never gave it any mind.\n" +
                "It just doesn't look that interesting. Actually, you'd even call it old. Aged. Probably dirty, with\n" +
                "nothing of actual value to sell you. And yet, as you're standing on the opposite side of the road\n" +
                "with some unexpected extra time on your hands, you find yourself... oddly curious.");
        System.out.println("\nAs you walk over to peer through the small windows, you see nothing but dusty bottles of \n" +
                "various sizes and large drapes of colorful cloth. As disregarded as the shop window seems, the door \n" +
                "beside it is quite opposite. It's strangely clean, with a bright neonlight sign that says: \"Enter\". \n");
    }

    public void enterStore() {
        System.out.println("\nNot knowing what to expect, you glance behind you before pushing open the door and taking \n" +
                "a tentative step inside. \"Welcome to the Potion Store!\" Two voices cry in unison before you can even \n" +
                "take a look around. Your gaze instantly searches for the origin of the sound, finding a large brown \n" +
                "cash desk with two people behind it. On the left, a younger boy with a mischievious grin on his face. \n" +
                "You'd guess him to be around 16 years old. He's leaning forward, elbows resting on the mahogany counter \n" +
                "as his chin rests on his hands. He appears blessed with a full head of brown curls, lively brown eyes \n" +
                "and a face full of freckles. Yet his nose seems too large for his face, as if someone pasted it on afterwards\n\n" +
                "On the right, an older woman, probably in her sixties, stares intensily at you with her sharp silver \n" +
                "eyes from behind half-moon glasses. It's as if she's trying to look straight through you, reading your \n" +
                "thoughts instead of your body language. Although you feel uncomfortable at first, she exudes an aura of \n" +
                "hard-earned wisdom and a willingness to share it. Just like the boy, she has a full head of curly hair.\n" +
                "Dark gray, tied together in a thick, messy bun. She gestures to herself and the boy as she speaks:\n" +
                "\"Only one of us can help you today, do choose quickly if you will, we don't have all day.\"\n");
    }

    public void doNotEnterStore() {
        System.out.println("\nYour gaze goes from the door back to the street, and back to the door. Eventually, you decide\n" +
                "to be incredibly boring, and walk away from the premise. Leaving the little store AND the story\n" +
                "behind.\n\nBut hey, at least you made it out in one piece.\n");
        System.out.println("RESULT: YOU WALKED AWAY.");
        System.out.println("--------------------------------- GAME OVER ---------------------------------\n");
    }

    //PATH YOUNG BOY
    public void youngBoy(){
        System.out.println("\nYou nod towards the young boy, and as you walk towards him his mischievious grin widens.\n" +
                "\"I think our guest made an excellent choice!\" He exclaims to the older woman, who quietly rolls her\n" +
                "eyes as she turns away from the both of you and leaves the room. Was it just you or did her shoulders\n" +
                "hang just a little bit? It must hurt to be rejected. \n" +
                "\n" +
                "\"And what is our dear guest called?\" the boy asks expectantly, demanding your attention again.\n" +
                "(enter your name below)");
        name = View.getInstance().getUserDecision();
        System.out.println("\nThe boy gives you a long look from under his curly locks. \"Very well, "+name+", my name is\n" +
                "Peter and I bid you welcome to our humble Potion Shop! Although to be honest I'd call it more of a\n" +
                "laboratory. However, I digress, that's not why you're here, is it, "+name+"?\" He grins that same grin, as\n" +
                "if he knows exactly what made you enter the store today.");
        System.out.println("(Press enter to continue)");
        View.getInstance().getUserDecision();
        System.out.println("Peter extends his arm to your right, gesturing to an area filled with all kinds of bottles.\"The alchemy\n" +
                "corner to your left contains all the usual potions, love, weather, or common vitamin tablets.\" He explains.\n" +
                "And you're intrigued: different colors of smoke hang in the air, expelled by some of the glowing open flasks and vials.\n\n" +
                "\"Next to our potions,\" he continues, and your gaze follows his hand to many different, dusky items basking\n" +
                "in the orange glow of a multitude of lit candles: \"we also sell old valuables that we've picked up on\n" +
                "our travels around the globe.\" For some reason this area strikes you as a bit eerie.");
        System.out.println("(Press enter to continue)");
        View.getInstance().getUserDecision();
        System.out.println("\"In the corner behind you...\" Peter continues, \"...we sell books. Mostly spellbooks and scrolls,\n" +
                "but a couple of other things as well.\" The area he gestures to now is a bit darker than the rest,\n" +
                "but you can still make out stacks of books, papers, and a lot of fine quills and ink bottles.\n\n" +
                "\"And here, on your left, is my favorite area: the gallery. You can't leave without taking a look at\n" +
                "these paintings, I highly recommend you see these. They're very special.\"\n\n" +
                "Peter turns back to you, smiling again. \"One more thing. VERY IMPORTANT. You can only buy ONE item\n" +
                "per visit here. I repeat, ONE item. So do choose carefully today. Now, what interests you, "+name+"?\"\n");
    }

    public void youngBoyAlchemyCorner(){
        System.out.println("\n---------------------------- THE ALCHEMY CORNER ----------------------------");
        System.out.println("You look around in amazement at the multitude of colors and effects happening around you.\n" +
                "Some potions jump from flask to flask, others seem to boil by themselves, and a few even drip upwards,\n" +
                "directly defying gravity.\n\n" +
                "There are two things standing out to you here. At the middle of a glass table, there's a large\n" +
                "potion bottle designed in the shape of a star, pointing upwards. It's golden liquid mimics rays of\n" +
                "sunlight, flowing around inside, moving from one point of the star to the other. The label reads:\n" +
                "Potion of Success: Excel at everything you do for 24 hours. WARNING: Can only be used once per human\n" +
                "being. Contains 5 portions. Overdose causes dementia. Use before the age of 60. \n\n" +
                "And in the cupboard on your left, a blue-ish glass flask has a miniature, heavy-looking cloud floating\n" +
                "inside of it. This label reads: Potion of Rain. Throw at desired location for a 20 min downpour.\n" +
                "Affected area: 1 square meter. Often used for showering at remote locations.\n");
    }

    public void youngBoyPotionOfSuccess(){
        System.out.println("\nPeter tilts his head at you, then picks up the star-shaped bottle, offering you to hold it.\n" +
                "\"Going for the cream of the crop, are you, "+name+"?\" he chuckles. \"This potion is the hardest\n" +
                "to make, but also the most worthwhile, if you can keep yourself in check and not use all of it, that is.\"\n\n" +
                "Holding the item, its contents speed up in your hands, and you're surprised by how simply holding it\n" +
                "makes you feel more confident. You -know- you can take on the world. You are full of unlimited potential,\n" +
                "just waiting to express itself. You can climb mountains, create records, build that which hasn't been\n" +
                "built before. You can really make a mark on this earth and if you took this potion, you could do that\n" +
                "right -NOW-.\n\n" +
                "\"What does it cost?\" You ask, entertaining the idea. \n" +
                "Peter smiles again, then shrugs. \"2000 swedish crowns, and a toenail.\"\n" +
                "Upon seeing your look, Peter adds shushingly: \"Don't worry, your toenail will grow back.\"\n");
    }

    public void youngBoyPotionOfSuccessBuy() {
        System.out.println("\nYou look from your shoes to the boy, then nod slowly. Heck, why not. He can have your toenail.\n\n" +
                "Peter is clearly very pleased as he guides you to the back of the room, past a curtain patterned \n" +
                "with starry wizard hats and into a chair that looks like it's made of real tree bark. He gestures for\n" +
                "you to take a seat and relax. It's hard to relax however, especially on a chair as uncomfortable as\n" +
                "this one.\n\n" +
                "Eventually, the boy returns with what looks like an ink-black vial, exactly the size of your big toe. \n" +
                "\"Don't worry "+name+", this'll just take a second.\" he says reassuringly, and places the vial around\n" +
                "one of your big toes. It contracts tightly for a moment, and as it expands again, it tears the toenail\n" +
                "cleanly from your toe: you feel absolutely nothing. What a relief!");
        System.out.println("(Press enter to continue)");
        View.getInstance().getUserDecision();
        System.out.println("After your toe has been properly bandaged, you get up and walk with him to the cash register where you \n" +
                "swipe your card for the 2000 crowns. The fact that they even have a pin machine doesn't really concern\n" +
                "you at this point. What just happened is stuck on your mind. You just lost a toenail. That was weird.\n\n" +
                "You hold the star-shaped potion close as you finally leave the store, but as soon as your injured foot\n" +
                "crosses the threshold between store and outside pavement, a searing pain shoots up from your toe through\n" +
                "your leg. The kind of pain you'd expect from having a toenail ripped off.");
        System.out.println("(Press enter to continue)");
        View.getInstance().getUserDecision();
        System.out.println("Only, this pain never stops. But you bear it.\n" +
                "This potion of success will be worth it, even if you're crippled for life.\n\n" +
                "RESULT: YOU BOUGHT THE POTION OF SUCCESS AND ARE CRIPPLED FOR LIFE.");
        System.out.println("--------------------------------- GAME OVER ---------------------------------\n");
    }

    public void youngBoyPotionOfRain(){
        System.out.println("\nPeter gestures for you to pick up the bottle yourself, and you do so carefully,\n" +
                "not wanting to drop it. It feels cold and slightly damp. The cloud inside shifts in\n" +
                "accordance with your movement as you hold it up in front of you, admiring the magic of it. \n\n" +
                "\"A nice choice, for sure.\" Peter nods, crossing his arms as he watches you. \"It's one of\n" +
                "the safer choices, good for a -mere beginning- magic user, I'd say.\" You can't help but wonder\n" +
                "if his tone of voice was meant to be insulting, but you let it slide and inquire about the price.\n\n" +
                "Peter straightens up. \"This one's 600 swedish crowns and a single strand of hair.\"\n" +
                "You raise your eyebrow at him and asks if he's joking. He shrugs, then smiles: \"It's a bargain.\"\n");
    }

    public void youngBoyPotionOfRainBuy(){
        System.out.println("\"I'll take it.\" you smile back.\n" +
                "The boy gives you his usual grin and motions for you to walk back to the counter with him. \"What are\n" +
                " you going to do with it, "+name+"?\"\n\n" +
                "You frown, thinking. You're not entirely sure yet, but this potion seems like a useful thing, and the\n" +
                "fact that Peter called it one of the safer choices sits well with you. \n\n" +
                "By the cash register, you pay him the amount he asked for, and pull a single strand of hair from your\n" +
                "skull, handing it over with a sceptical look on your face. Peter takes the hair from your hand with\n" +
                "unexpected reverence and places it in a drawer, that, to your disgust, is filled with lots of other\n" +
                "hair strands. \n\n" +
                "Something's weird. \n" +
                "You leave the store, taking the cold potion with you.\n\n" +
                "Outside, you glance back one more time, seeing the older woman standing in the doorframe, watching you\n" +
                "leave. Her shoulders are still hanging ever so slightly, before she turns around and goes back inside,\n" +
                "closing the door behind her. That's when you notice strands of hair laying on the pavement, floating in\n" +
                "the wind, resting on your jacket. \n\n" +
                "RESULT: YOU BOUGHT THE POTION OF RAIN AND ARE BALD FOR LIFE\n");
        System.out.println("--------------------------------- GAME OVER ---------------------------------\n");
    }

    public void youngBoyAntiqueCollection(){
        System.out.println("To be continued.");
    } //TODO
    public void youngBoyBookSection(){
        System.out.println("To be continued.");
    } //TODO
    public void youngBoyGallery(){
        System.out.println("To be continued.");
    } //TODO


    //PATH OLDER WOMAN
    public void olderWoman(){
        System.out.println("To be continued.");
    } //TODO
    public void olderWomanAlchemyCorner(){
        System.out.println("To be continued.");
    } //TODO
    public void olderWomanAntiqueCollection(){
        System.out.println("To be continued.");
    } //TODO
    public void olderWomanBookSection(){
        System.out.println("To be continued.");
    } //TODO
    public void olderWomanGallery(){
        System.out.println("To be continued.");
    } //TODO


}
