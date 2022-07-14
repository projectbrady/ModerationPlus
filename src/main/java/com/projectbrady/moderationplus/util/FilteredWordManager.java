package com.projectbrady.moderationplus.util;

import com.projectbrady.moderationplus.Main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilteredWordManager {

    private final Set<String> bannedWords = new HashSet<>();

    public boolean isBanned(String sentence) {

        for(String bannedWord : this.bannedWords) {
            if(sentence.contains(bannedWord))
                return true;
        }

        return false;
    }

    public void reloadFromConfig() {
        this.bannedWords.clear();
        List<String> words = Main.config.getStringList("Blacklisted");
        System.out.println("Loading the following words:");
        words.forEach(System.out::println);
        bannedWords.addAll(words);
    }


}