import re
import sys
from googletrans import Translator

def translate_text(text, target_language):
    translator = Translator()
    translation = translator.translate(text, dest=target_language)
    return translation.text

# Accept command line arguments
text_to_translate = sys.argv[1]
target_language_long = sys.argv[2]
target_language = ""

# Abbreviate the target language for Google Translate
if target_language_long == "english":
    target_language = "en"
elif target_language_long == "german":
    target_language = "de"

def informalizeSourceText(text):
    sentences = re.split(r'(?<!\w\.\w.)(?<![A-Z][a-z]\.)(?<=\.|\?|\!)\s', text)
    greetings = ["Hey bro, " + sentence for sentence in sentences]
    result = ' '.join(greetings)
    return result

def informalizeTranslatedText(text):
    text = text.replace("Hey Bruder, ", "")
    text = text.replace("Hallo Bruder, ", "")
    sentences = re.split(r'(?<!\w\.\w.)(?<![A-Z][a-z]\.)(?<=\.|\?|\!)\s', text)
    greetings = [sentence.capitalize()[0] + sentence[1:] for sentence in sentences]
    text = ' '.join(greetings)
    return text

# Translate and return the text
if target_language_long == "german":
	text_to_translate = informalizeSourceText(text_to_translate)
translated_text = translate_text(text_to_translate, target_language)
if target_language_long == "german":
	translated_text = informalizeTranslatedText(translated_text)
print(translated_text)
